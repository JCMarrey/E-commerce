package com.ecommerce.service;

import java.util.List;
import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Producto;


public interface CarritoService {

	public Carrito agregarProductoCarrito (	int idCarrito, int idProducto);
	
	public void eliminarProductoCarritoById(int idCarrito, int idProducto);
	
	public List<Producto> findAll (int idCarrito);
	
	public Carrito buscarMiCarrito (int idCarrito);
	
}
