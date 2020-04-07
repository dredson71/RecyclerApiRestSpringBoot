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
@RequestMapping("condominio")
public class CondominioController {
	@Autowired
	private CondominioDAO condominioDAO;
	
	@GetMapping
	public ResponseEntity<List<Condominio>> getCondominio(){
		List<Condominio> condominios = condominioDAO.findAll();
		return ResponseEntity.ok(condominios);
	}
	
	@PostMapping
	public ResponseEntity<Condominio> createCondominio(@RequestBody Condominio condominio){
		Condominio newCondominio = condominioDAO.save(condominio);
		return ResponseEntity.ok(newCondominio);
	}
	@RequestMapping(value="{condominioID}")
	public ResponseEntity<Condominio> getCondominioById(@PathVariable("condominioID") Integer condominioID){
		Optional<Condominio>optionalCondominio = condominioDAO.findById(condominioID);
		if(!optionalCondominio.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optionalCondominio.get());
		}
	}

}
