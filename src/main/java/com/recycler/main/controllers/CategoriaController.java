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
@RequestMapping("categoria")
public class CategoriaController {
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getCategoria(){
		List<Categoria> categorias = categoriaDAO.findAll();
		return ResponseEntity.ok(categorias);
	}
	
	
	@PostMapping
	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria){
		Categoria newCategoria = categoriaDAO.save(categoria);
		return ResponseEntity.ok(newCategoria);
	}
	@RequestMapping(value="{categoriaID}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable("categoriaID") Integer categoriaID){
		Optional<Categoria>optionalCategoria = categoriaDAO.findById(categoriaID);
		if(optionalCategoria.isPresent()) {
			return ResponseEntity.ok(optionalCategoria.get());
		}else {
			return ResponseEntity.noContent().build();

		}
	}

}
