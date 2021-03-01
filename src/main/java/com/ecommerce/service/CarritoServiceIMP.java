package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Producto;
import com.ecommerce.repository.CarritoRepository;

@Service
public class CarritoServiceIMP  implements CarritoService{

	@Autowired(required = true)
	CarritoRepository carritoRepository;
	
	@Override
	public Carrito agregarProductoCarrito(Carrito carrito, Producto producto) {
		
		//hacen referencia para agregar tabla de manytomany carrito_has_product
		carrito.getProductos().add(producto);
		producto.getCarrito().add(carrito);
		return this.carritoRepository.save(carrito);
	}

	@Override
	public void eliminarProductoCarritoById(int idProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> findAll(int idCarrito) {
		// TODO Auto-generated method stub
		return null;
	}

}
