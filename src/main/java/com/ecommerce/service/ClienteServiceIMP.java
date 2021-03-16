package com.ecommerce.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Cliente;
import com.ecommerce.repository.ClienteRespository;

@Service
public class ClienteServiceIMP implements ClienteService {

	@Autowired(required = true)
	private ClienteRespository clienteRepository;
	
	@Override
	@Transactional
	public Cliente save(Cliente c) {
		
		//buscar si el nombre de usuario ya existe...
		
		Iterable<Cliente> clientes = clienteRepository.findAll();
		for (Cliente clienteN : clientes) {
			//si existe algún usuario con el mismo nombre de usuario no se agrega.
			if (clienteN.getNombreUsuario().equalsIgnoreCase(c.getNombreUsuario())) {
				return null;
			}
		}	
		//generar el carrito de comprar y aparte guardar al nuevo usuario...
		
		Carrito miCarrito = new Carrito ();
		c.setCarritoCompras(miCarrito);
		miCarrito.setCliente(c);
		return clienteRepository.save(c);
	}
	
	@Override
	@Transactional (readOnly = true)
	public Optional<Cliente> findById(Integer id) {
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional (readOnly = true)
	public Iterable<Cliente> findAll() {
		
		return clienteRepository.findAll();
	}
	
	
	public Cliente findClienteSesion(String nombre, String password) {
		Cliente clienteSesion = clienteRepository.findClienteSesion(nombre, password);
		
		if(clienteSesion == null){
			//no hay cliente o algún campo érroneo 
			return null;
		}
		return clienteSesion;
		
	}

	@Override
	public int  buscarCarritoUsuario(String nombreUsuario) {
		return clienteRepository.buscarCarritoUsuario(nombreUsuario);
	}

}
