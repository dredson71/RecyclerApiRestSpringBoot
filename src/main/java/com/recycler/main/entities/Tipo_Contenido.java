package com.recycler.main.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Tipo_Contenido")
public class Tipo_Contenido {
	
	@Id
	@Column(name = "TipoContenido_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Codigo;
	
	@Column(name="Nombre",nullable = false,length = 20)
	private String Nombre;
	
	@Column(name="Abreviatura",nullable = false,length = 5)
	private String Abreviatura;
	
	@OneToMany(mappedBy = "tipo_Contenido")
	private List<Producto> productos;
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getAbreviatura() {
		return Abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		Abreviatura = abreviatura;
	}
	
	

}
