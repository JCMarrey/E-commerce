package com.ecommerce.entity;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Carrito")
public class Carrito {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;
	
	@Column (name = "fechaAgregado")
	private Date fechaAgregado = new Date();
	
	@Column (name = "horaAgregado")
	private Date horaAgregado;
	
	@Column (name = "cantidad")
	private int cantidad;
	
	@Column (name = "fechaEliminado")
	private Date fechaEliminado = new Date();
	
	@Column (name = "horaEliminado")
	private Date horaEliminado;
	
	@Column (name = "totalCantidadCarrito")
	private float totalCantidadCarrito;
	
	@JsonBackReference
	@OneToOne (fetch = FetchType.LAZY, mappedBy = "carritoCompras", cascade = CascadeType.ALL)
	private Cliente cliente;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name ="carrito_has_product",
		joinColumns = {@JoinColumn (name = "carritoId" )},
		inverseJoinColumns = {@JoinColumn (name = "productoId")})
	private Set <Producto> productos = new HashSet <>();

	public Carrito() {
		
	}
	
	public Carrito (int idCarrito) {
		this.idCarrito = idCarrito;
	}
	public Carrito(int cantidad, float totalCantidadCarrito) {
		super();
		this.cantidad = cantidad;
		this.totalCantidadCarrito = totalCantidadCarrito;
	}

	public Carrito( Date fechaAgregado, Date horaAgregado, int cantidad, Date fechaEliminado,
			Date horaEliminado, float totalCantidadCarrito, Set<Producto> productos) {
		
		this.fechaAgregado = fechaAgregado;
		this.horaAgregado = horaAgregado;
		this.cantidad = cantidad;
		this.fechaEliminado = fechaEliminado;
		this.horaEliminado = horaEliminado;
		this.totalCantidadCarrito = totalCantidadCarrito;
		this.productos = productos;
	}

	public Carrito(float totalCantidadCarrito) {

		this.totalCantidadCarrito = totalCantidadCarrito;
		
	}
	
	
	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Date getFechaAgregado() {
		return fechaAgregado;
	}

	public void setFechaAgregado(Date fechaAgregado) {
		this.fechaAgregado = fechaAgregado;
	}

	public Date getHoraAgregado() {
		return horaAgregado;
	}

	public void setHoraAgregado(Date horaAgregado) {
		this.horaAgregado = horaAgregado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaEliminado() {
		return fechaEliminado;
	}

	public void setFechaEliminado(Date fechaEliminado) {
		this.fechaEliminado = fechaEliminado;
	}

	public Date getHoraEliminado() {
		return horaEliminado;
	}

	public void setHoraEliminado(Date horaEliminado) {
		this.horaEliminado = horaEliminado;
	}

	public float getTotalCantidadCarrito() {
		return totalCantidadCarrito;
	}

	public void setTotalCantidadCarrito(float totalCantidadCarrito) {
		this.totalCantidadCarrito = totalCantidadCarrito;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}