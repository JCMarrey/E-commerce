package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.CarritoUsuarioBusqueda;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface BusquedaRepository extends JpaRepository <CarritoUsuarioBusqueda, Integer> {

	@Modifying
	@Transactional
	@Query(
			value = "UPDATE carrito_usuario_busqueda_reviews SET fecha_eliminado =?1 WHERE carrito_usuario_busqueda_reviews.id_carrito= ?2 ",
			nativeQuery = true)
	public int agregarFechaProductoEliminado (Date fechaEliminada, int idCarrito);
	

	@Query(
			
			value = "SELECT id_usuario from clientes WHERE clientes.mi_carrito_compras =  ?1",
			nativeQuery = true)
	public int buscarUsuarioCarrito (int idCarrito);
	
	
}
