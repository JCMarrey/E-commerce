package com.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "favoritos")
public class Favorito {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFavoritos;

	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name ="favorito_producto",
		joinColumns = {@JoinColumn (name = "idFavoritos" )},
		inverseJoinColumns = {@JoinColumn (name = "productoId")})
	private Set <Producto> productos = new HashSet <>();
	
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonBackReference
	@OneToOne (fetch = FetchType.LAZY, mappedBy = "favoritos", cascade = CascadeType.ALL)
	private Cliente cliente;


	public int getIdFavoritos() {
		return idFavoritos;
	}


	public void setIdFavoritos(int idFavoritos) {
		this.idFavoritos = idFavoritos;
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


	public Favorito(int idFavoritos) {
		super();
		this.idFavoritos = idFavoritos;
	}
	
	public Favorito() {
		
	}
	
	
	
}
