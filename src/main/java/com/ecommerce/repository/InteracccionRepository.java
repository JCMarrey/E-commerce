package com.ecommerce.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.FavoritoUsuarioInteraccion;
import com.ecommerce.entity.Interaccion;

@Repository
public interface InteracccionRepository extends JpaRepository <FavoritoUsuarioInteraccion, Integer>{
	
	@Modifying
	@Transactional
	@Query(
			value = "UPDATE favorito_usuario_interacciones SET fecha_eliminado =?1 WHERE favorito_usuario_interacciones.id_favoritos= ?2 and "
					+ "favorito_usuario_interacciones.id_producto= ?3",
			nativeQuery = true)
	public int agregarFechaProductoEliminado (String fechaEliminada, int idFavorito, int idProducto);
	
	@Modifying
	@Transactional
	@Query(
			
			value = "INSERT INTO favorito_usuario_interacciones(fecha_agregado,fecha_eliminado, id_favoritos, id_producto,id_usuario)"
					+ "values (?1,?2,?3,?4,?5) ",
			nativeQuery = true)
	public void guardarInteraccionUsuario (String fechaBusqueda, String fechaEliminado, int favorito, int idProducto,int idUsuario);
	
	@Modifying
	@Transactional
	@Query(
			
			value = "INSERT INTO interacciones_cliente(fecha_busqueda,hora_busqueda, id_cliente, id_producto)"
					+ "values (?1,?2,?3,?4) ",
			nativeQuery = true)
	public void guardarInteraccionProducto (String fechaBusqueda, String hora_busqueda, int idCliente, int idProducto);
	

}
