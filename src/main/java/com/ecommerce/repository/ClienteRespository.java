package com.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Integer> {
	@Query(
			value = "SELECT*FROM clientes WHERE clientes.nombre_usuario = ?1 AND clientes.password = ?2 ",
			nativeQuery = true)
		public Cliente findClienteSesion (String nombre,String password);


	@Query(
			value = "SELECT mi_carrito_compras FROM clientes WHERE clientes.nombre_usuario = ?1 ",
			nativeQuery = true)
	public int  buscarCarritoUsuario(String nombreUsuario);
	
	
	@Query(
			value = "SELECT  id_usuario FROM clientes WHERE clientes.nombre_usuario = ?1 ",
			nativeQuery = true)
	public int buscarIdUsuario (String nombreUsuario);
}
