package com.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.entity.Carrito;

//agregar producto a carrito
//eliminar producto de un carrito
//visualizar carrito
//eliminar todo el carrito

@Repository
public interface CarritoRepository  extends JpaRepository <Carrito, Integer>{
	
	@Modifying
	@Transactional
	@Query(
			value = "DELETE FROM carrito_has_product WHERE carrito_has_product.carrito_id = ?1  AND  "
					+ "carrito_has_product.producto_id = ?2",					
			nativeQuery = true)
	public void  eliminarProductoCarrito(int idCarrito, int idProducto);
	
	
	@Query(
			value = "SELECT*FROM carrito WHERE id_carrito = ?1",
			nativeQuery = true)
	public Carrito  buscaMiCarrito(int idCarrito);
	
	

	
}
