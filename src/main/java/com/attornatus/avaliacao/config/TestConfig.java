package com.attornatus.avaliacao.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.attornatus.avaliacao.entities.Endereco;
import com.attornatus.avaliacao.entities.Pessoa;
import com.attornatus.avaliacao.repositories.PessoaRepository;
import com.attornatus.avaliacao.resources.EnderecoResource;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoResource enderecoResource;
	
	@Override
	public void run(String... args) throws Exception {
		
		Pessoa pessoa1 = new Pessoa(null, "Maria", Instant.parse("1991-01-01T00:00:00Z"));
		Pessoa pessoa2 = new Pessoa(null, "Carlos", Instant.parse("1992-02-02T00:00:00Z"));
		
		Endereco endereco1 = new Endereco(null, "Rua A", "02000-001", 12, "SP", pessoa1, true);
		Endereco endereco2 = new Endereco(null, "Avenida B", "02000-002", 34, "RJ", pessoa2, false);
		Endereco endereco3 = new Endereco(null, "Alameda C", "02000-003", 56, "ES", pessoa1, false);
		Endereco endereco4 = new Endereco(null, "Rua D", "02000-004", 78, "SP", pessoa1, true);
		
		pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2));
		
		enderecoResource.isEnderecoPrincipal(Arrays.asList(endereco1, endereco2, endereco3, endereco4));
		
	}
	
}
