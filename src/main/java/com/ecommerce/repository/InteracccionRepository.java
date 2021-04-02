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
			value = "UPDATE favorito_usuario_interacciones SET fecha_eliminado =?1 WHERE favorito_usuario_interacciones.id_favoritos= ?2 ",
			nativeQuery = true)
	public int agregarFechaProductoEliminado (String fechaEliminada, int idFavorito);
	
	@Modifying
	@Transactional
	@Query(
			
			value = "INSERT INTO favorito_usuario_interacciones(fecha_agregado,fecha_eliminado, id_favoritos, id_producto,id_usuario)"
					+ "values (?1,?2,?3,?4,?5) ",
			nativeQuery = true)
	public void guardarInteraccionUsuario (String fechaBusqueda, String fechaEliminado, int favorito, int idProducto,int idUsuario);
	

}
