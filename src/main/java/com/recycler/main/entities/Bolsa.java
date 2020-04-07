package com.recycler.main.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="Bolsa")
public class Bolsa {
	
	@Id
	@Column(name = "Bolsa_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Codigo;
	
	@Column(name = "CreadoFecha",nullable = false)
	private Date CreadoFecha;
	
	@Column(name = "RecojoFecha",nullable = false)
	private Date RecojoFecha;
	
	@Column(name = "Puntuacion",nullable = false)
	private int Puntuacion;
	
	@ManyToOne
	@JoinColumn(name = "Usuario_ID")
	private Usuario usuario;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "QrCode_ID")
	private QrCode qrCode;
	
    @OneToMany(mappedBy = "bolsa",cascade = CascadeType.ALL)
    private Set<Producto_Bolsa> productosBolsas= new HashSet<>();
	
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public Date getCreadoFecha() {
		return CreadoFecha;
	}
	public void setCreadoFecha(Date creadoFecha) {
		CreadoFecha = creadoFecha;
	}
	public Date getRecojoFecha() {
		return RecojoFecha;
	}
	public void setRecojoFecha(Date recojoFecha) {
		RecojoFecha = recojoFecha;
	}
	public int getPuntuacion() {
		return Puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		Puntuacion = puntuacion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public QrCode getQrCode() {
		return qrCode;
	}
	public void setQrCode(QrCode qrCode) {
		this.qrCode = qrCode;
	}
	
	
	

}
