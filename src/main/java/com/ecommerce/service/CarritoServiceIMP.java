package com.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Producto;
import com.ecommerce.repository.CarritoRepository;
import com.ecommerce.repository.ProductoRepository;

@Service
public class CarritoServiceIMP  implements CarritoService{

	@Autowired(required = true)
	CarritoRepository carritoRepository;
	
	@Autowired(required = true)
	ProductoRepository productoRepository;
	
	@Override
	@Transactional
	public Carrito agregarProductoCarrito(int idCarrito, int idProducto) {
		
		//hacen referencia para agregar tabla de manytomany carrito_has_product
		
		//buscarProducto para recolectarInformación
		
		Producto productoAdd = productoRepository.buscarProducto(idProducto);
		Carrito carritoAdd =  carritoRepository.buscaMiCarrito(idCarrito);
		
		//si el producto y el carrito existen
		if(productoAdd != null && carritoAdd != null) {
			carritoAdd.getProductos().add(productoAdd);
			productoAdd.getCarrito().add(carritoAdd);
			return this.carritoRepository.save(carritoAdd);
		}
		return null;
	}

	@Override
	@Transactional
	public void eliminarProductoCarritoById(int carrito,int idProducto) {
		
		this.carritoRepository.eliminarProductoCarrito(carrito, idProducto);

	}
	@Override
	public List<Producto> findAll(int idCarrito) {
		return null;
	}

	@Override
	public Carrito buscarMiCarrito(int idCarrito) {
		return carritoRepository.buscaMiCarrito(idCarrito);
		
	}

}
