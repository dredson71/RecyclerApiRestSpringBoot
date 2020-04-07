package com.recycler.main.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Condominio")
public class Condominio {
	
	@Id
	@Column(name = "Condominio_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Codigo;
	
	@Column(name="Nombre",nullable = false,length = 50)
	private String Nombre;
	
	@Column(name="Direccion",nullable = false,length = 50)
	private String Direccion;
	
	@ManyToOne
	@JoinColumn(name = "Distrito_ID")
	private Distrito distrito;
	
	@OneToMany(mappedBy = "condominio")
	private List<Usuario> usuarios;
	
	
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
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	

}
