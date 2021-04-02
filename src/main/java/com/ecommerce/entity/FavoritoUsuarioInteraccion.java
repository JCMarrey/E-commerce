package com.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favoritoUsuarioInteracciones")
public class FavoritoUsuarioInteraccion {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "idFavoritos")
	private int idFavorito;
	
	@Column (name = "idProducto")
	private int idProducto;
	
	@Column (name = "fechaAgregado")
	private Date fechaAgregado = new Date();
	
	@Column (name = "fechaEliminado" )
	private Date fechaEliminado;
	
	@Column (name = "idUsuario")
	private int idUsuario;
	
	
public FavoritoUsuarioInteraccion() {
		
	}

	public FavoritoUsuarioInteraccion(int id) {
		
		this.id = id;
	}

	public FavoritoUsuarioInteraccion(int id, int idFavorito, int idProducto, Date fechaAgregado, Date fechaEliminado, int idUsuario) {
		
		this.id = id;
		this.idFavorito = idFavorito;
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

	public int getIdFavorito() {
		return idFavorito;
	}

	public void setIdFavorito(int idCarrito) {
		this.idFavorito = idCarrito;
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
