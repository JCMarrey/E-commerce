package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Favorito;
import com.ecommerce.entity.Producto;
import com.ecommerce.repository.FavoritoRepository;
import com.ecommerce.repository.ProductoRepository;


@Service
public class FavoritoIMP implements FavoritoService {

	@Autowired(required = true)
	FavoritoRepository favoritoRepository;
	
	@Autowired(required = true)
	ProductoRepository productoRepository;
	
	@Override
	public int buscarIDFavoritos(int idUsuario) {
		
		
		return favoritoRepository.buscarIDFavoritos(idUsuario);
	}

	@Override
	public Favorito agregarProductoFavorito(int idFavorito, int idProducto) {
				
		Producto productoAdd = productoRepository.buscarProducto(idProducto);
		int idF =  favoritoRepository.buscarIDFavoritos(idFavorito);
		Favorito favoritoAdd = new Favorito (idF);	
				//si el producto y el carrito existen
				if(productoAdd != null && favoritoAdd != null) {
					favoritoAdd.getProductos().add(productoAdd);
					productoAdd.getFavorito().add(favoritoAdd);
					return favoritoRepository.save(favoritoAdd);
				}
		return null;
	}

}
