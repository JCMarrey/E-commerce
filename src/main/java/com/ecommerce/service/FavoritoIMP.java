package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Favorito;
import com.ecommerce.repository.FavoritoRepository;


@Service
public class FavoritoIMP implements FavoritoService {

	@Autowired(required = true)
	FavoritoRepository favoritoRepository;
	
	@Override
	public int buscarIDFavoritos(int idUsuario) {
		
		return favoritoRepository.buscarIDFavoritos(idUsuario);
	}

}
