package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Favorito;
import com.ecommerce.entity.Producto;
import com.ecommerce.repository.ClienteRespository;
import com.ecommerce.repository.FavoritoRepository;
import com.ecommerce.repository.ProductoRepository;

@Service
public class FavoritoIMP implements FavoritoService {

	@Autowired(required = true)
	FavoritoRepository favoritoRepository;
	
	@Autowired(required = true)
	ProductoRepository productoRepository;
	
	@Autowired (required = true )
	ClienteRespository clienteRepository;
	
	
	@Override
	public Favorito buscarIDFavoritos(int idUsuario) {
		
		return favoritoRepository.busquedaIDFavorito(idUsuario); 
	}

	@Override
	public Favorito agregarProductoFavorito(int idUsuario, int idProducto) {
				
		Producto productoAdd = productoRepository.buscarProducto(idProducto);
		Favorito favoritoAdd = favoritoRepository.busquedaIDFavorito(idUsuario);
				//si el producto y el favorito existen
		if(productoAdd != null && favoritoAdd != null) {
					favoritoAdd.getProductos().add(productoAdd);
					productoAdd.getFavorito().add(favoritoAdd);
					
					return favoritoRepository.save(favoritoAdd);
				}
		return null;
	}

	@Override
	public void eliminarProductoFavoritoById(int idFavorito, int idProducto) {
		
		favoritoRepository.eliminarProductoCarrito(idFavorito, idProducto);
	}



}
