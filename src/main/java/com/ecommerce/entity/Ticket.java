package com.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTicket;
	
	@Column(name = "idCliente")
	private int idCliente;
	
	@Column(name = "idCompra")
	private int idCompra;
	
	@Column(name = "nombreCliente")
	private String nombreCliente;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "domicilio")
	private String domicilio;
	
	@Column(name = "telefono")
	private long telefono;
	
	//detalles producto
	@Column(name = "nombreProducto")
	private String nombreProducto;
	
	@Column(name = "descripcionProducto")
	private String descripcionProducto;
	
	//detalles compra
	
	@Column(name = "fechaCompra")
	private String fechaCompra;
	
	@Column(name = "montoPagado")
	private float montoPagado;

	@Column(name ="fechaEntrega")
	private String fechaEntrega;
	
	@Column (name = "estadoPedido")
	private String estadoPedido;
	
	
	public Ticket(int idTicket) {
		super();
		this.idTicket = idTicket;
	}

	public Ticket() {
		super();
	}

	public Ticket(int idTicket, int idCliente, int idCompra, String nombreCliente, String apellidos, String correo,
			String domicilio, long telefono, String nombreProducto, String descripcionProducto, String fechaCompra,
			float montoPagado, String fechaE, String estadoP) {
		super();
		this.idTicket = idTicket;
		this.idCliente = idCliente;
		this.idCompra = idCompra;
		this.nombreCliente = nombreCliente;
		this.apellidos = apellidos;
		this.correo = correo;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.fechaCompra = fechaCompra;
		this.montoPagado = montoPagado;
		this.fechaEntrega = fechaE;
		this.estadoPedido = estadoP;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public float getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(float montoPagado) {
		this.montoPagado = montoPagado;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	
}
