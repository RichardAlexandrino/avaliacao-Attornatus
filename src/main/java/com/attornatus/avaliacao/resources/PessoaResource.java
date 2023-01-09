package com.attornatus.avaliacao.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.avaliacao.entities.Pessoa;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@GetMapping
	public ResponseEntity<Pessoa> findAll() {
		Pessoa pessoa1 = new Pessoa("Maria", "13/08/1996");
		return ResponseEntity.ok().body(pessoa1);
	}
}
