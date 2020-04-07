package com.recycler.main.entities;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@Column(name="Usuario_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Codigo;
	
	@Column(name="Nombre",nullable = false,length = 50)
	private String Nombre;
	
	@Column(name="Apellido",nullable = false,length = 50)
	private String Apellido;
	
	@Column(name="DNI",nullable = false,length = 8)
	private String DNI;
	
	@Column(name="Direccion",nullable = false,length = 50)
	private String Direccion;
	
	@Column(name="Email",nullable = false,length = 50)
	private String Email;
	
	@Column(name="Password",nullable = false,length = 150)
	private String Password;
	
	@Column(name="Salt",nullable = false,length = 100)
	private String Salt;
	
	@ManyToOne
	@JoinColumn(name = "Condominio_ID")
	private Condominio condominio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Sexo_ID")
	private Sexo sexo;
	
	@ManyToOne
	@JoinColumn(name = "TipoUsuario_ID")
	private Tipo_Usuario tipo_Usuario;
	
	@OneToMany(mappedBy = "usuario")
	private List<Bolsa> bolsas;
	
	
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
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSalt() {
		return Salt;
	}
	public void setSalt(String salt) {
		Salt = salt;
	}
	public Condominio getCondominio() {
		return condominio;
	}
	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Tipo_Usuario getTipo_Usuario() {
		return tipo_Usuario;
	}
	public void setTipo_Usuario(Tipo_Usuario tipo_Usuario) {
		this.tipo_Usuario = tipo_Usuario;
	}
	
	

}
