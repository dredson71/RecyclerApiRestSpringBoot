package com.recycler.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycler.main.entities.Bolsa;

public interface BolsaDAO extends JpaRepository<Bolsa,Integer> {
	
}
