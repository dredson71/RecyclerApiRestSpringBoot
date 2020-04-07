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
@RequestMapping("tipocontenido")
public class Tipo_ContenidoController {

	@Autowired
	private Tipo_ContenidoDAO tipo_ContenidoDAO;
	
	@GetMapping
	public ResponseEntity<List<Tipo_Contenido>> getTipoContenido(){
		List<Tipo_Contenido> tipoContenidos = tipo_ContenidoDAO.findAll();
		return ResponseEntity.ok(tipoContenidos);
	}
	
	@PostMapping
	public ResponseEntity<Tipo_Contenido> createTipoContenido(@RequestBody Tipo_Contenido tipoContenido){
		Tipo_Contenido newTipoContenido = tipo_ContenidoDAO.save(tipoContenido);
		return ResponseEntity.ok(newTipoContenido);
	}
	
	@RequestMapping(value="{tipoContenidoId}")
	public ResponseEntity<Tipo_Contenido> getUsuarioById(@PathVariable("tipoContenidoId") Integer tipoContenidoId){
		Optional<Tipo_Contenido>optionalTipoContenido = tipo_ContenidoDAO.findById(tipoContenidoId);
		if(!optionalTipoContenido.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optionalTipoContenido.get());
		}
	}
}
