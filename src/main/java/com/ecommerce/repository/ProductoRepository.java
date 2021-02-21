package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Producto;

//usar los métodos de Jpa y realizar el crud repository
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
}
