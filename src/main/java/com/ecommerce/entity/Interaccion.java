package com.ecommerce.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "interaccionesCliente")
public class Interaccion {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInteracciones;
	
	@Column(name = "idCliente")
	private int idCliente;
	
	@Column(name = "idProducto")
	private int idProducto;
	
	@Column(name = "fechaBusqueda")
	private String fechaBusqueda;
	
	@Column(name = "horaBusqueda")
	private String horaBusqueda;
	

	public Interaccion() {
		
	}
	public Interaccion(int idInteracciones) {
		
		this.idInteracciones = idInteracciones;
	}

	public Interaccion(int idCliente, int idProducto, String fechaBusqueda, String horaBusqueda) {
		
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.fechaBusqueda = fechaBusqueda;
		this.horaBusqueda = horaBusqueda;
	}

	public int getIdInteracciones() {
		return idInteracciones;
	}

	public void setIdInteracciones(int idInteracciones) {
		this.idInteracciones = idInteracciones;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getFechaBusqueda() {
		Date fechaBusqueda = new Date();
		SimpleDateFormat fechaActual = new SimpleDateFormat("dd-MM-YYYY");
		return fechaActual.format(fechaBusqueda);
	}

	public void setFechaBusqueda(String fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}

	public String getHoraBusqueda() {
		Date fechaBusqueda = new Date();
		SimpleDateFormat fechaActual = new SimpleDateFormat("hh:mm:ss");
		return fechaActual.format(fechaBusqueda);
	}

	public void setHoraBusqueda(String horaBusqueda) {
		this.horaBusqueda = horaBusqueda;
	}
	
	
	
	

}
