package com.recycler.main.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="Producto")
public class Producto {

	@Id
	@Column(name = "Producto_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Codigo;
	
	@Column(name="Barcode",nullable = false,length = 50)
	private String Barcode;
	
	@Column(name="Nombre",nullable = false,length = 50)
	private String Nombre;
	
	@Column(name="Peso",nullable = false)
	private double Peso;
	
	@Column(name="Contenido",nullable = false)
	private double Contenido;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "Categoria_ID")
	private Categoria categoria;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "TipoContenido_ID")
	private Tipo_Contenido tipo_Contenido;
	
	@OneToMany(mappedBy = "producto")
	private List<Probolsa> bolsaproductos;
	
	
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getBarcode() {
		return Barcode;
	}
	public void setBarcode(String barcode) {
		Barcode = barcode;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getPeso() {
		return Peso;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}
	public double getContenido() {
		return Contenido;
	}
	public void setContenido(double contenido) {
		Contenido = contenido;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Tipo_Contenido getTipo_Contenido() {
		return tipo_Contenido;
	}
	public void setTipo_Contenido(Tipo_Contenido tipo_Contenido) {
		this.tipo_Contenido = tipo_Contenido;
	}
	
	
	
}

