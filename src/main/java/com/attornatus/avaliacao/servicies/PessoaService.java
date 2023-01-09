package com.attornatus.avaliacao.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.avaliacao.entities.Pessoa;
import com.attornatus.avaliacao.repositories.PessoaRepository;
import com.attornatus.avaliacao.servicies.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Pessoa findById(Long id) {
		Optional <Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Pessoa create(Pessoa obj) {
		return repository.save(obj);
	}
	
	public Pessoa edit(Long id, Pessoa obj) {
		Pessoa entity = repository.getReferenceById(id);
		editData(entity, obj);
		return repository.save(entity);
	}

	private void editData(Pessoa entity, Pessoa obj) {
		entity.setNome(obj.getNome());
		entity.setDataDeNascimento(obj.getDataDeNascimento());
	}
	
}
