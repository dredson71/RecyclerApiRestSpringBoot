package com.recycler.main.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name="Producto_Bolsa")
public class Producto_Bolsa implements Serializable {
	
	
	private int Cantidad;
	
	private int Puntuacion;
	private double Peso;
	
	@Id
    @ManyToOne
    @JoinColumn
	private Bolsa bolsa;
	
	@Id
    @ManyToOne
    @JoinColumn
	private Producto producto;
	

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto_Bolsa)) return false;
        Producto_Bolsa that = (Producto_Bolsa) o;
        return Objects.equals(producto.getNombre(), that.producto.getNombre()) &&
                Objects.equals(bolsa.getCodigo(), that.bolsa.getCodigo()) &&
                Objects.equals(Puntuacion, that.Puntuacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto.getNombre(), bolsa.getCodigo(), Puntuacion);
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
	public double getPeso() {
		return Peso;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}
	
	
	
}

