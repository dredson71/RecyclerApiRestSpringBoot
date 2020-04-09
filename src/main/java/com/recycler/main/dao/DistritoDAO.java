package com.recycler.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recycler.main.entities.Departamento;
import com.recycler.main.entities.Distrito;

public interface DistritoDAO extends JpaRepository<Distrito,Integer>  {
	@Query("select a from Distrito a where a.departamento.Nombre = ?1")
	List<Distrito> findByDepartamentoNombre(String Nombre);
}
