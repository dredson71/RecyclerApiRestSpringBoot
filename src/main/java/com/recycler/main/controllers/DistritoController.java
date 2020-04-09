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
@RequestMapping("distrito")
public class DistritoController {
	
	@Autowired
	private DistritoDAO distritoDAO;
	
	@GetMapping
	public ResponseEntity<List<Distrito>> getDistrito(){
		List<Distrito> distritos = distritoDAO.findAll();
		return ResponseEntity.ok(distritos);
	}
	@PostMapping
	public ResponseEntity<Distrito> createDistrito(@RequestBody Distrito distrito){
		Distrito newDistrito = distritoDAO.save(distrito);
		return ResponseEntity.ok(newDistrito);
	}
	
	/*@RequestMapping(value="{ditritoID}")
	public ResponseEntity<Distrito> getDistritoById(@PathVariable("ditritoID") Integer ditritoID){
		Optional<Distrito>optionalDistrito = distritoDAO.findById(ditritoID);
		if(!optionalDistrito.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optionalDistrito.get());
		}
	}*/
	
	@RequestMapping(value="{departamento}")
	public ResponseEntity<List<Distrito>> getDistritosByDepartamento(@PathVariable("departamento") String departamento) {
		List<Distrito>distritos = distritoDAO.findByDepartamentoNombre(departamento);
		return ResponseEntity.ok(distritos);
	}
	

}
