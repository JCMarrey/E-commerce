package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Compra;
@Repository
public interface CompraRepository extends  JpaRepository <Compra, Integer> {
	
	
	@Modifying
	@Transactional 
	@Query(value = "UPDATE compras SET estado_compra =?1 where compras.id_compras =?2",
	           nativeQuery = true)
	public void finalizarCompra(String estado, int idCompra);
	
	
	@Modifying
	@Transactional
	@Query(
			value = "INSERT INTO compra_has_producto (id_compras,id_producto) VALUES (?,?)",
			nativeQuery = true)	
	public void agregarCompraHasProducto(int idCompra,int idProducto);
	
	
	@Query(
			value = "SELECT id_compras FROM compras WHERE id_usuario = ?1 and hora_compra =?2",
			nativeQuery = true)	
	public int obtenerIdCompraHasProducto(int idUsuario,String horaCompra);
	
	@Modifying
	@Transactional 
	@Query(value = "UPDATE compras SET estado_compra =?1 where compras.id_compras =?2",
	           nativeQuery = true)
	public void cancelarCompra (String accion, int idCompra);

}
