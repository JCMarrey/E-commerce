package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.entity.Favorito;


@Repository
public interface FavoritoRepository extends JpaRepository <Favorito, Integer> {

	@Query(
			value = "SELECT clientes.id_favoritos FROM  clientes WHERE clientes.id_usuario  = ?1",
			nativeQuery = true)
	public int  buscarIDFavoritos(int id_usuario);
	
}
