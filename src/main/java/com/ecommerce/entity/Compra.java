package com.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="compras")
public class Compra {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompras;
	
	@Column(name = "fechaCompra")
	private String fechaCompra;
	
	@Column(name = "horaCompra")
	private String horaCompra;
	
	@Column(name = "montoPagado")
	private float montoPagado;
	
	@Column(name = "metodoPago")
	private String metodoPago;
	
	@Column(name = "idUsuario")
	private int idUsuario;
	
	@Column (name = "estadoCompra")
	private String estadoCompra;
	
	public Compra () {
		
	}
	public Compra (int idCompra) {
		
	}
	public Compra(int idCompra, String fechaCompra, String horaCompra, float montoPagado, String metodoPago) {
		
		this.idCompras = idCompra;
		this.fechaCompra = fechaCompra;
		this.horaCompra = horaCompra;
		this.montoPagado = montoPagado;
		this.metodoPago = metodoPago;
	}

	public int getIdCompra() {
		return idCompras;
	}

	public void setIdCompra(int idCompra) {
		this.idCompras = idCompra;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getHoraCompra() {
		return horaCompra;
	}

	public void setHoraCompra(String horaCompra) {
		this.horaCompra = horaCompra;
	}

	public float getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(float montoPagado) {
		this.montoPagado = montoPagado;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public int getIdCompras() {
		return idCompras;
	}
	public void setIdCompras(int idCompras) {
		this.idCompras = idCompras;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEstadoCompra() {
		return estadoCompra;
	}
	public void setEstadoCompra(String estadoCompra) {
		this.estadoCompra = estadoCompra;
	}
	
	
	
}
