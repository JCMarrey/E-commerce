package com.ecommerce.service;

import java.util.List;


import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Producto;


public interface CarritoService {

	public Carrito agregarProductoCarrito (Carrito carrito, Producto producto);
	
	public void eliminarProductoCarritoById(int idProducto);
	
	public List<Producto> findAll (int idCarrito);
}
