package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Carrito;


//agregar producto a carrito
//eliminar producto de un carrito
//visualizar carrito
//eliminar todo el carrito

@Repository
public interface CarritoRepository  extends JpaRepository <Carrito, Integer>{
}
