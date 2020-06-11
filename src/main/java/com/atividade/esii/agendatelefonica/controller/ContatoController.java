package com.atividade.esii.agendatelefonica.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.esii.agendatelefonica.repository.ContatoRepository;

@Service
@RestController
public class ContatoController {
	
	private ContatoRepository repository;
	
	public ContatoController(ContatoRepository repository) {
		this.repository = repository;
	}
	
}
