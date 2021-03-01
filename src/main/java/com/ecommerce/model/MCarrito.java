package com.ecommerce.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ecommerce.entity.Producto;

public class MCarrito {
	
	private int idCarrito;
	private Date fechaAgregado = new Date();
	private Date horaAgregado;
	private int cantidad;
	private Date fechaEliminado = new Date();
	private Date horaEliminado;
	private float totalCantidadCarrito;
	private Set <Producto> productos = new HashSet <>();

	public MCarrito() {
		
	}
	
	public MCarrito(int cantidad, float totalCantidadCarrito) {
		super();
		this.cantidad = cantidad;
		this.totalCantidadCarrito = totalCantidadCarrito;
	}

	public MCarrito(int idCarrito, Date fechaAgregado, Date horaAgregado, int cantidad, Date fechaEliminado,
			Date horaEliminado, float totalCantidadCarrito, Set<Producto> productos) {
		super();
		this.idCarrito = idCarrito;
		this.fechaAgregado = fechaAgregado;
		this.horaAgregado = horaAgregado;
		this.cantidad = cantidad;
		this.fechaEliminado = fechaEliminado;
		this.horaEliminado = horaEliminado;
		this.totalCantidadCarrito = totalCantidadCarrito;
		this.productos = productos;
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
	
	
}
