package com.recycler.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycler.main.entities.Departamento;

public interface DepartamentoDAO extends JpaRepository<Departamento,Integer> {

}
