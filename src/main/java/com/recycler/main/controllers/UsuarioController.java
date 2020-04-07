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
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuario(){
		List<Usuario> usuarios = usuarioDAO.findAll();
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
		Usuario newUsuario = usuarioDAO.save(usuario);
		return ResponseEntity.ok(newUsuario);
	}
	
	@RequestMapping(value="{usuarioId}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("usuarioId") Integer usuarioId){
		Optional<Usuario>optionalUsuario = usuarioDAO.findById(usuarioId);
		if(!optionalUsuario.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optionalUsuario.get());
		}
	}
}
