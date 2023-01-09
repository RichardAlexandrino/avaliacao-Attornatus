package com.attornatus.avaliacao.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.attornatus.avaliacao.entities.Pessoa;
import com.attornatus.avaliacao.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa pessoa1 = new Pessoa(null, "Maria", "1/1/1991");
		Pessoa pessoa2 = new Pessoa(null, "Carlos", "2/2/1992");
		
		pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2));
	}
	
}
