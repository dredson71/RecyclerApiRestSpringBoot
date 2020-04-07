package com.recycler.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recycler.main.dao.*;
import com.recycler.main.entities.*;

@RestController
@RequestMapping("bolsa")
public class BolsaController {
	@Autowired
	private BolsaDAO bolsaDAO;
	
	@GetMapping
	public ResponseEntity<List<Bolsa>> getBolsa(){
		List<Bolsa> bolsas = bolsaDAO.findAll();
		return ResponseEntity.ok(bolsas);
	}
	
	@PostMapping
	public ResponseEntity<Bolsa> createBolsa(@RequestBody Bolsa bolsa){
		Bolsa newBolsa = bolsaDAO.save(bolsa);
		return ResponseEntity.ok(newBolsa);
	}
	
	@RequestMapping(value="{bolsaId}")
	public ResponseEntity<Bolsa> getBolsaById(@PathVariable("bolsaId") Integer bolsaId){
		Optional<Bolsa>optionalBolsa = bolsaDAO.findById(bolsaId);
		if(optionalBolsa.isPresent()) {
			return ResponseEntity.ok(optionalBolsa.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	

}
