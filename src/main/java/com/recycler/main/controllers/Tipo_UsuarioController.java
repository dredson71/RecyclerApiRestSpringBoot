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
@RequestMapping("tipousuario")
public class Tipo_UsuarioController {
	
	@Autowired
	private Tipo_UsuarioDAO tipo_usuarioDAO;
	
	@GetMapping
	public ResponseEntity<List<Tipo_Usuario>> getUsuario(){
		List<Tipo_Usuario> tipoUsuarios = tipo_usuarioDAO.findAll();
		return ResponseEntity.ok(tipoUsuarios);
	}
	
	@PostMapping
	public ResponseEntity<Tipo_Usuario> createTipoUsuario(@RequestBody Tipo_Usuario tipoUsuario){
		Tipo_Usuario newTipoUsuario = tipo_usuarioDAO.save(tipoUsuario);
		return ResponseEntity.ok(newTipoUsuario);
	}
	
	@RequestMapping(value="{tipoUsuarioId}")
	public ResponseEntity<Tipo_Usuario> getUsuarioById(@PathVariable("tipoUsuarioId") Integer tipoUsuarioId){
		Optional<Tipo_Usuario>optionalTipoUsuario = tipo_usuarioDAO.findById(tipoUsuarioId);
		if(!optionalTipoUsuario.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optionalTipoUsuario.get());
		}
	}

}
