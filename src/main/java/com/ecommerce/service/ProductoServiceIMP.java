package com.ecommerce.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Producto;
import com.ecommerce.repository.FavoritoRepository;
import com.ecommerce.repository.ProductoRepository;

@Service
public class ProductoServiceIMP implements ProductoService {

	@Autowired(required = true)
	private ProductoRepository productoRepository;
	
	@Autowired(required = true)
	private FavoritoRepository favoritoRepository;
	
	//método de lectura solo devuelve productos
	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() { return productoRepository.findAll(); }
	
	
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

	
	//para leer los productos que se van a buscar
	@Override
	public List<Producto> findAll(String keyWord) {
		if( keyWord != null) {
			return productoRepository.findAll(keyWord);		
		}
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> verDetallesProducto(int idProducto) {
		return this.productoRepository.findById(idProducto);
	}

	
	@Override
	@Transactional
	public Producto buscarProducto(int idProducto) {
		return productoRepository.buscarProducto(idProducto);
	}

	@Override
	public List<Producto> misProductosCarrito(int idCarrito) {
		return productoRepository.misProductosCarrito(idCarrito);
	}

	@Override
	public List<Producto> findProductosCategoria(String categoria) {
		if( categoria != null) {
			return productoRepository.productosCategoria(categoria); //paginate		
		}
		return productoRepository.findAll();
	}


	@Override
	public List<Producto> misProductosFavoritos(int idFavoritos) {
		return productoRepository.misProductosFavorito(idFavoritos);
	}

	

}
