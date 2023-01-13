package com.attornatus.avaliacao.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.avaliacao.entities.Endereco;
import com.attornatus.avaliacao.entities.Pessoa;
import com.attornatus.avaliacao.repositories.EnderecoRepository;
import com.attornatus.avaliacao.servicies.EnderecoService;
import com.attornatus.avaliacao.servicies.PessoaService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private EnderecoRepository enderecoRepository;

	/**
	 * Lista os endereços
	 * 
	 * @return {link ResponseEntity<List<Endereco>>}
	 */
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> list = enderecoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	/**
	 * Verifica o endereço pelo seu código de identificação
	 * 
	 * @param id
	 * @return {link ResponseEntity<<Endereco>>}
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		Endereco obj = enderecoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Verifica e ajusta o endereço principal da pessoa
	 * 
	 * @param enderecos
	 */
	public void isEnderecoPrincipal(List<Endereco> enderecos) {
		for (Endereco endereco : enderecos) {
			if (Boolean.TRUE.equals(endereco.getEnderecoPrincipal())) {
				List<Endereco> listaDeEnderecos = new ArrayList<Endereco>();
				Pessoa pessoa = pessoaService.findById(endereco.getPessoa().getId());
				listaDeEnderecos = pessoa.getEnderecos();
				if (listaDeEnderecos.isEmpty()) {
					endereco.setEnderecoPrincipal(Boolean.TRUE);
				} else {
					for (Endereco e : listaDeEnderecos) {
						if (Boolean.TRUE.equals(e.getEnderecoPrincipal())) {
							e.setEnderecoPrincipal(Boolean.FALSE);
							enderecoRepository.save(e);
						}
					}
					endereco.setEnderecoPrincipal(Boolean.TRUE);
				}
			} else {
				List<Endereco> listaDeEnderecos = new ArrayList<Endereco>();
				Pessoa pessoa = pessoaService.findById(endereco.getPessoa().getId());
				listaDeEnderecos = pessoa.getEnderecos();
				if (listaDeEnderecos.isEmpty()) {
					endereco.setEnderecoPrincipal(Boolean.TRUE);
				}
			}
			enderecoRepository.save(endereco);
		}
	}
	
}
