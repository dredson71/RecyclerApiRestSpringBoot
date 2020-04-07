package com.recycler.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycler.main.entities.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria,Integer>  {

}
