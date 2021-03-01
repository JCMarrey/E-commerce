package com.ecommerce.model;

import com.ecommerce.entity.Producto;

public class MProducto {
	private int id;
	public MProducto() {
	
	}
	public MProducto(int id, String nombre, String descripcion, String tags, String status, String img,
			String categoria, int calificacion) {
		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tags = tags;
		this.status = status;
		this.img = img;
		this.categoria = categoria;
		this.calificacion = calificacion;
	}
	public MProducto(int id) {
		this.id=id;
	}
	
	public MProducto(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public MProducto(Producto p) {
		this.id = p.getId();
		this.nombre = p.getNombre();
		this.descripcion = p.getDescripcion();
		this.tags = p.getTags();
		this.status = p.getStatus();
		this.img = p.getImg();
		this.categoria = p.getCategoria();
		this.calificacion = p.getCalificacion();
	}
	public MProducto(int id, String nombre, String descripcion, float precio, String tags, String img, String categoria,
			int calificacion, String status) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tags = tags;
		this.img = img;
		this.categoria = categoria;
		this.calificacion = calificacion;
		this.status = status;
	}
	
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



	private String nombre;
	private String descripcion;
	private float precio;
	private String tags;
	private String img;
	private String categoria;
	private int calificacion;
	private String status;
	
	
}
