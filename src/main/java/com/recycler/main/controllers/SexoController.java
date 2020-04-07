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
@RequestMapping("sexo")
public class SexoController {
	@Autowired
	private SexoDAO sexoDAO;
	
	@GetMapping
	public ResponseEntity<List<Sexo>> getSexo(){
		List<Sexo> sexos = sexoDAO.findAll();
		return ResponseEntity.ok(sexos);
	}
	
	@PostMapping
	public ResponseEntity<Sexo> createSexo(@RequestBody Sexo sexo){
		Sexo newSexo = sexoDAO.save(sexo);
		return ResponseEntity.ok(newSexo);
	}
	
	@RequestMapping(value="{sexoID}")
	public ResponseEntity<Sexo> getUsuarioById(@PathVariable("sexoID") Integer sexoID){
		Optional<Sexo>optionalSexo= sexoDAO.findById(sexoID);
		if(!optionalSexo.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optionalSexo.get());
		}
	}

}
