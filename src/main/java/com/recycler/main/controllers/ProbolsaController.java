package com.recycler.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recycler.main.dao.ProbolsaDAO;
import com.recycler.main.entities.Probolsa;
import com.recycler.main.entities.Producto;

@RestController
@RequestMapping("probolsa")
public class ProbolsaController {
	
	@Autowired
	private ProbolsaDAO distritoDAO;
	
	@GetMapping
	public ResponseEntity<List<Probolsa>> getProbolsa(){
		List<Probolsa> probolsas = distritoDAO.findAll();
		return ResponseEntity.ok(probolsas);
	}
	
	@PostMapping
	public ResponseEntity<Probolsa> createProductoBolsa(@RequestBody Probolsa producto){
		Probolsa newProducto = distritoDAO.save(producto);
		return ResponseEntity.ok(newProducto);
	}
}
