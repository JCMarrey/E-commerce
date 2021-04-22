package com.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="compra_has_producto")
public class CompraProducto {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "idCompras")
	private int idCompras;
	
	
	@Column(name = "idProducto")
	private int idProducto;

	
	public CompraProducto() {
		
	}
	
	
	
public CompraProducto(int id, int idCompras, int idProducto) {
		super();
		this.id = id;
		this.idCompras = idCompras;
		this.idProducto = idProducto;
	}



public CompraProducto(int id) {
		this.id = id;
	}
	
	

	public int getIdCompras() {
	return idCompras;
}

public void setIdCompras(int idCompras) {
	this.idCompras = idCompras;
}

public int getIdProducto() {
	return idProducto;
}

public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
