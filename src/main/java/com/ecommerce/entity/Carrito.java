package com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "carrito")
public class Carrito {
	
	//relacion one to many
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;
	
	private String idProducto;
	
	private String imgProducto;
	
	private String nombreProducto;
	
	private String descripcionProducto;
	
	private int cantidadProducto;
	
	private float precio;
	
}
