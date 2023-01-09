package com.attornatus.avaliacao.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.avaliacao.entities.Pessoa;
import com.attornatus.avaliacao.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Pessoa findById(Long id) {
		Optional <Pessoa> obj = repository.findById(id);
		return obj.get();
	}
	
	public Pessoa create(Pessoa obj) {
		return repository.save(obj);
	}
	
}
