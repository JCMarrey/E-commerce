package com.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carritoUsuarioBusquedaReviews")
public class CarritoUsuarioBusqueda {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "idCarrito")
	private int idCarrito;
	
	@Column (name = "idProducto")
	private int idProducto;
	
	@Column (name = "fechaAgregado")
	private Date fechaAgregado = new Date();
	
	@Column (name = "fechaEliminado" )
	private Date fechaEliminado;
	
	@Column (name = "idUsuario")
	private int idUsuario;
	

	public CarritoUsuarioBusqueda() {
		
	}

	public CarritoUsuarioBusqueda(int id) {
		
		this.id = id;
	}

	public CarritoUsuarioBusqueda(int id, int idCarrito, int idProducto, Date fechaAgregado, Date fechaEliminado, int idUsuario) {
		
		this.id = id;
		this.idCarrito = idCarrito;
		this.idProducto = idProducto;
		this.fechaAgregado = fechaAgregado;
		this.fechaEliminado = fechaEliminado;
		this.idUsuario = idUsuario;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Date getFechaAgregado() {
		return fechaAgregado;
	}

	public void setFechaAgregado(Date fechaAgregado) {
		this.fechaAgregado = fechaAgregado;
	}

	public Date getFechaEliminado() {
		return fechaEliminado;
	}

	public void setFechaEliminado(Date fechaEliminado) {
		this.fechaEliminado = fechaEliminado;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

}
