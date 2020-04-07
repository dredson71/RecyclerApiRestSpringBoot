package com.recycler.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycler.main.entities.Producto;

public interface ProductoDAO extends JpaRepository<Producto,Integer>  {

}
