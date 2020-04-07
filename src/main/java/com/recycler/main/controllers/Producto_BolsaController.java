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

import com.recycler.main.dao.Producto_BolsaDAO;
import com.recycler.main.entities.Producto_Bolsa;

@RestController
@RequestMapping("producto_bolsa")
public class Producto_BolsaController {
	
	@Autowired
	private Producto_BolsaDAO productoBolsaDAo;
	
	@GetMapping
	public ResponseEntity<List<Producto_Bolsa>> getProductoBolsa(){
		List<Producto_Bolsa> productosBolsas = productoBolsaDAo.findAll();
		return ResponseEntity.ok(productosBolsas);
	}

}

