package com.ecommerce.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Producto;

@Repository
public interface HistorialRepository  extends JpaRepository<Producto, Integer>{
	
	@Query(
			value = "SELECT * FROM productos where productos.id IN "
					+ "(SELECT interacciones_cliente.id_producto FROM interacciones_cliente WHERE id_cliente = ?1)   ",
			nativeQuery = true)
	
	public ArrayList <Producto> productosBasadosHistorial (int idCliente);

}
