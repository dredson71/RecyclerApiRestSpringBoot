package com.recycler.main.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="QrCode")
public class QrCode {
	
	@Id
	@Column(name = "QrCode_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Codigo;
	
	@Column(name = "QrCode", nullable = false,length = 20)
	private String QrCode;
	
	@Column(name = "CreadoFecha", nullable = false)
	private Date CreadoFecha;
	
	@OneToOne(mappedBy = "qrCode", fetch = FetchType.LAZY)
	private Bolsa bolsa;
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getQrCode() {
		return QrCode;
	}
	public void setQrCode(String qrCode) {
		QrCode = qrCode;
	}
	public Date getCreadoFecha() {
		return CreadoFecha;
	}
	public void setCreadoFecha(Date creadoFecha) {
		CreadoFecha = creadoFecha;
	}
	
	

}
