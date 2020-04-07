package com.recycler.main.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Tipo_Usuario")
public class Tipo_Usuario {

	@Id
	@Column(name = "TipoUsuario_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Codigo;
	
	@Column(name="Nombre",nullable = false,length = 20)
	private String Nombre;
	
	@OneToMany(mappedBy = "tipo_Usuario")
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
	
	
}
