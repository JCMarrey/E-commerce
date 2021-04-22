package com.ecommerce.service;

import com.ecommerce.entity.CarritoUsuarioBusqueda;
import com.ecommerce.entity.Favorito;

public interface FavoritoService {

	public Favorito buscarIDFavoritos (int idUsuario);
	
	public Favorito agregarProductoFavorito(int idFavorito, int idProducto);
	
	public void eliminarProductoFavoritoById(int idFavorito, int idProducto);
	
	
}

