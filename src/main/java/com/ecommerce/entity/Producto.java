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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="productos")
public class Producto {
	
	public Producto() {
		
	}
	
	public Producto(String descripcion, String categoria) {
		super();
		this.descripcion = descripcion;
		this.categoria = categoria;
	}

	public Producto(int id) {
		super();
		this.id = id;
	}

	public Producto(int id, String nombre, String descripcion, float precio, String tags, String status, String img, String categoria,
			int calificacion) {
	
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tags = tags;
		this.status = status;
		this.img = img;
		this.categoria = categoria;
		this.calificacion = calificacion;
		this.precio = precio;
	}
	
	

	public Producto(String nombre, String descripcion, float precio, String tags, String status, String img,
			String categoria, int calificacion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tags = tags;
		this.status = status;
		this.img = img;
		this.categoria = categoria;
		this.calificacion = calificacion;
	}



	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private float precio;
	
	@Column(name="tags")
	private String tags;
	
	@Column(name="status")
	private String status;
	
	@Column(name="img")
	private String img;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="calificacion")
	private int calificacion;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productos")
	private Set <Carrito> carrito = new HashSet <>();

	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productos")
	private Set <Favorito> favorito = new HashSet <>();
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Set<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(Set<Carrito> carrito) {
		this.carrito = carrito;
	}
	
	
	
	
		
}