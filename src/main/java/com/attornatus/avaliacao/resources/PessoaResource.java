package com.attornatus.avaliacao.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.attornatus.avaliacao.entities.Pessoa;
import com.attornatus.avaliacao.servicies.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService service;
	
	/**
	 * Lista as pessoas
	 * 
	 * @return {link ResponseEntity<List<Pessoa>>}
	 */
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/**
	 * Verifica a pessoa pelo seu código de identificação
	 * 
	 * @param id
	 * @return {link ResponseEntity<<Pessoa>>}
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Pessoa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/**
	 * Implementar um novo cadastro de pessoa
	 * 
	 * @param obj
	 * @return {link ResponseEntity<<Pessoa>>}
	 */
	@PostMapping
	public ResponseEntity<Pessoa> create(@RequestBody Pessoa obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	/**
	 * Atualizar dados um pessoa
	 * 
	 * @param id
	 * @param obj
	 * @return {link ResponseEntity<<Pessoa>>}
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> edit(@PathVariable Long id, @RequestBody Pessoa obj) {
		obj = service.edit(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
