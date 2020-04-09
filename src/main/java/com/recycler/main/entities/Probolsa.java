package com.recycler.main.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="ProductoBolsa")
public class Probolsa {

	@Id
	@Column(name = "ProductoBolsa_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Codigo;
	
	@Column(name="Peso",nullable = false)
	private double Peso;
	
	@Column(name="Cantidad",nullable = false)
	private int Cantidad;
	
	@Column(name="Puntuacion",nullable = false)
	private int Puntuacion;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "Bolsa_ID")
	private Bolsa bolsa;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "Producto_ID")
	private Producto producto;
	
	
	
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public double getPeso() {
		return Peso;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}
	
	
	
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public int getPuntuacion() {
		return Puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		Puntuacion = puntuacion;
	}
	public Bolsa getBolsa() {
		return bolsa;
	}
	public void setBolsa(Bolsa bolsa) {
		this.bolsa = bolsa;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
	
	
	
}
