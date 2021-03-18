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
@Table ( name = "busquedaCliente")
public class BusquedaCliente {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBusqueda;
	
	@Column(name = "descripcionBusqueda")
	private String descripcionBusqueda;
	
	@Column(name = "fechaBusqueda")
	private String fechaBusqueda;
	
	@Column(name = "horaBusqueda")
	private String horaBusqueda;
	
	@Column(name = "idUsuario")
	private int idUsuario;
	
	public BusquedaCliente(String descripcionBusqueda, int idUsuario) {
		
		this.descripcionBusqueda = descripcionBusqueda;
		this.idUsuario = idUsuario;
	}
	
	
	
	
	public BusquedaCliente() {
		super();
	}




	public BusquedaCliente(String descripcionBusqueda, String fechaBusqueda, String horaBusqueda, int idUsuario) {
		super();
		this.descripcionBusqueda = descripcionBusqueda;
		this.fechaBusqueda = fechaBusqueda;
		this.horaBusqueda = horaBusqueda;
		this.idUsuario = idUsuario;
	}




	public BusquedaCliente(int idBusqueda) {
		super();
		this.idBusqueda = idBusqueda;
	}
	public int getIdBusqueda() {
		return idBusqueda;
	}
	public void setIdBusqueda(int idBusqueda) {
		this.idBusqueda = idBusqueda;
	}
	public String getDescripcionBusqueda() {
		return descripcionBusqueda;
	}
	public void setDescripcionBusqueda(String descripcionBusqueda) {
		this.descripcionBusqueda = descripcionBusqueda;
	}
	/*public Date getFechaBusqueda() {
		return fechaBusqueda;
	}*/
	
	//método para mandar la fecha y cargarla a la BD
	
	public String obtenerFechaBusqueda() {
		Date fechaBusqueda = new Date();
		SimpleDateFormat fechaActual = new SimpleDateFormat("dd-MM-YYYY");
		return fechaActual.format(fechaBusqueda);
	}
	
	
	public String obtenerHoraBusqueda() {
		Date fechaBusqueda = new Date();
		SimpleDateFormat fechaActual = new SimpleDateFormat("hh:mm:ss");
		return fechaActual.format(fechaBusqueda);
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getHoraBusqueda() {
		return horaBusqueda;
	}
	public void setHoraBusqueda(String horaBusqueda) {
		this.horaBusqueda = horaBusqueda;
	}
	
	
	
	
}
