package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Favorito;


@Repository
public interface FavoritoRepository extends JpaRepository <Favorito, Integer> {
	
	@Query(
			value = "SELECT * FROM `favoritos` WHERE favoritos.id_favoritos in ( SELECT clientes.id_favoritos from "
					+ "clientes where  clientes.id_usuario = ?1) ",
			nativeQuery = true)
	public Favorito busquedaIDFavorito (int idUsuario);
	
	@Modifying
	@Transactional
	@Query(
			value = "DELETE FROM favorito_producto WHERE favorito_producto.id_favoritos = ?1  AND  "
					+ "favorito_producto.producto_id = ?2",					
			nativeQuery = true)
	public void  eliminarProductoCarrito(int idFavorito, int idProducto);
}
