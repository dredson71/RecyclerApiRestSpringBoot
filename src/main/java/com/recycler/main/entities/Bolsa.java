package com.recycler.main.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Bolsa")
public class Bolsa {
	
	@Id
	@Column(name = "Categoria_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Codigo;
	
	@Column(name = "CreadoFecha",nullable=false)
	private Date CreadoFecha;
	
	@Column(name = "RecojoFecha",nullable=false)
	private Date RecojoFecha;
	
	@Column(name = "Puntuacion",nullable=false)
	private Date Puntuacion;

	@ManyToOne(optional=false)
	@JoinColumn(name = "Usuario_ID")
	private Usuario usuario;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "QrCode_ID")
	private QrCode qrCode;
	
	@OneToMany(mappedBy = "bolsa")
	private List<Probolsa> bolsaproductos;
	
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

