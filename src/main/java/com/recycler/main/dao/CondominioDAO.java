package com.recycler.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycler.main.entities.Condominio;

public interface CondominioDAO extends JpaRepository<Condominio,Integer>  {

}
