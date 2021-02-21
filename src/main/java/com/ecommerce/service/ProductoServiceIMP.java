package com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Producto;
import com.ecommerce.repository.ProductoRepository;

@Service
public class ProductoServiceIMP implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	//método de lectura solo devuelve productos
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {
		
		return productoRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Page<Producto> findAll(Pageable pageable) {
	
		//método que página
		return productoRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Producto save(Producto p) {
		
		return productoRepository.save(p);
	}
	
	//ahora si hace cambios en la BD
	@Transactional
	@Override
	public void deleteById(Integer id) {
		productoRepository.deleteById(id);	
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Producto> findById(Integer id) {
		return productoRepository.findById(id);
	}
}
