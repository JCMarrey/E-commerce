package com.ecommerce.service;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecommerce.entity.Producto;

public interface ProductoService {
	
	public Iterable <Producto> findAll();
	
	//método para la paginación

	public Page <Producto> findAll(Pageable pageable);
	
	//devuelve un optional
	
	public Optional <Producto> findById(Integer id);

	//guardar alguna entidad o actualizarla y regresar el producto
	
	public Producto save(Producto p);
	
	public void deleteById(Integer id);
	
	public List<Producto> findAll (String keyWord);
	
}
