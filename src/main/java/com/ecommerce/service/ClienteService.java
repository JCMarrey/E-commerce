package com.ecommerce.service;

import java.util.Optional;

import com.ecommerce.entity.Cliente;
public interface ClienteService {

	//solamente nos interesa registrar un usuario y realizar una búsqueda para asociarlo a las compras
	// y al carrito ...
	
	public Cliente  save (Cliente c);
	
	public Optional <Cliente> findById(Integer id);

	public Iterable<Cliente> findAll();

	public Cliente findClienteSesion (String nombre,String password);

	public int  buscarCarritoUsuario (String nombreUsuario);
}
