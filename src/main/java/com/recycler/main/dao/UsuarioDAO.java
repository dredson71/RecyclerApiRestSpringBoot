package com.recycler.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycler.main.entities.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario,Integer>  {

}
