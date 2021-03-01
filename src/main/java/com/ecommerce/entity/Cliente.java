package com.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "clientes")
public class Cliente {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name = "nombreUsuario")
	private String nombreUsuario;
	
	@Column(name = "nombreCliente")
	private String nombreCliente;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "edad")
	private byte edad;
	
	@Column(name = "sexo")
	private char sexo;
	
	@Column(name = "correoElectrónico")
	private String correoElectronico;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "domicilio")
	private String domicilio;
	
	@Column(name = "telefono")
	private long telefono;
	
	@Column(name = "tipoTarjeta")
	private String tipoTarjeta;
	
	@Column(name = "numeroTarjeta")
	private long numeroTarjeta;
	
	@Column(name ="ipUsuario")
	private String ipUsuario;
	

	@JsonManagedReference //evitar que se meta en el bucle infinito
	@OneToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn ( name = "miCarritoCompras", referencedColumnName = "idCarrito")
	private Carrito carritoCompras;
	
	public Cliente() {
		super();
	}
	public Cliente (String nombreUsuario, String nombreCliente, String password) {
		this.nombreCliente = nombreCliente;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}
	public Cliente(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Cliente(String nombreUsuario, String nombreCliente, String apellidos, byte edad, char sexo,
			String correoElectronico, String domicilio, long telefono, String tipoTarjeta, long numeroTarjeta,
			Carrito carrito) {
		this.nombreUsuario = nombreUsuario;
		this.nombreCliente = nombreCliente;
		this.apellidos = apellidos;
		this.edad = edad;
		this.sexo = sexo;
		this.correoElectronico = correoElectronico;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.tipoTarjeta = tipoTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.carritoCompras = carrito;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public byte getEdad() {
		return edad;
	}
	public void setEdad(byte edad) {
		this.edad = edad;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getIpUsuario() {
		return ipUsuario;
	}
	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}
	public Carrito getCarritoCompras() {
		return carritoCompras;
	}
	public void setCarritoCompras(Carrito carritoCompras) {
		this.carritoCompras = carritoCompras;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	//faltan más campos como ipUsuario, navegador etc.
	
}
