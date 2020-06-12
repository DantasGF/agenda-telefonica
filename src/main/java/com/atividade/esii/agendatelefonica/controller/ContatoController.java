package com.atividade.esii.agendatelefonica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.esii.agendatelefonica.model.Contato;
import com.atividade.esii.agendatelefonica.repository.ContatoRepository;

@Service
@RestController
public class ContatoController {
	
	private ContatoRepository repository;
	
	public ContatoController(ContatoRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/contatos")
	public ResponseEntity<?> inserir(@RequestBody Contato contato){
		return new ResponseEntity<>(repository.save(contato), HttpStatus.OK);
	}
	
	@GetMapping("/contatos")
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/contatos/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable(value = "id") long id){
		return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
	}
	
	@PutMapping("/contatos")
	public ResponseEntity<?> atualizar(@RequestBody Contato contato){
		return new ResponseEntity<>(repository.save(contato), HttpStatus.OK);
	}
	
	@DeleteMapping("/contatos/{id}")
	public ResponseEntity<?> deletar(@PathVariable(value = "id") long id){
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}