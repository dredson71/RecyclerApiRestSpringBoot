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
@RequestMapping("departamento")
public class DepartamentoController {
	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	@GetMapping
	public ResponseEntity<List<Departamento>> getDepartamento(){
		List<Departamento> departamentos = departamentoDAO.findAll();
		return ResponseEntity.ok(departamentos);
	}
	
	@PostMapping
	public ResponseEntity<Departamento> createDepartamento(@RequestBody Departamento departamento){
		Departamento newDepartamento = departamentoDAO.save(departamento);
		return ResponseEntity.ok(newDepartamento);
	}
	
	@RequestMapping(value="{departamentoID}")
	public ResponseEntity<Departamento> getDepartamentoById(@PathVariable("departamentoID") Integer departamentoID){
		Optional<Departamento>optionalDepartamento = departamentoDAO.findById(departamentoID);
		if(!optionalDepartamento.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optionalDepartamento.get());
		}
	}

}
