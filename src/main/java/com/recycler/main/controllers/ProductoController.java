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
@RequestMapping("producto")
public class ProductoController {

	@Autowired
	private ProductoDAO productoDAO;
	
	@GetMapping
	public ResponseEntity<List<Producto>> getProducto(){
		List<Producto> productos = productoDAO.findAll();
		return ResponseEntity.ok(productos);
	}
	
	@PostMapping
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
		Producto newProducto = productoDAO.save(producto);
		return ResponseEntity.ok(newProducto);
	}
	
	@RequestMapping(value="{productoId}")
	public ResponseEntity<Producto> getUsuarioById(@PathVariable("productoId") Integer productoId){
		Optional<Producto>optionalProducto = productoDAO.findById(productoId);
		if(!optionalProducto.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optionalProducto.get());
		}
	}
}
