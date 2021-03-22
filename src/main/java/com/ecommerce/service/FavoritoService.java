package com.ecommerce.service;

import com.ecommerce.entity.Favorito;

public interface FavoritoService {

	public int buscarIDFavoritos (int idUsuario);
	
	public Favorito agregarProductoFavorito(int idFavorito, int idProducto);
}

