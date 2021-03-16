package com.ecommerce.service;

import com.ecommerce.entity.CarritoUsuarioBusqueda;


//agregar producto a carrito
//modificar la eliminación de un producto en el carrito
//cambiar el estado de pendiente a comprado


public interface BusquedaService {
	public CarritoUsuarioBusqueda agregarProductoCarrito (int idCarrito, int idProducto, int idUsuario);
	
	public int buscarUsuarioCarrito (int idCarrito);
	
	
	public void agregarFechaProductoEliminado (int idCarrito);
}
