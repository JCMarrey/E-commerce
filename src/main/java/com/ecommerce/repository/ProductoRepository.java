package com.ecommerce.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.entity.Producto;


//usar los métodos de Jpa y realizar el crud repository
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	
	//método para realizar la búsqueda de productos con palabras claves

	
	@Query(
		value = "SELECT*FROM productos WHERE productos.nombre LIKE %?1%",
		nativeQuery = true)
	public List <Producto> findAll (String nombre);
	
	
	@Query(
			value = "SELECT*FROM productos WHERE id = ?1",
			nativeQuery = true)
	public Producto  buscarProducto(int idProducto);

	
	@Query(
			value = "SELECT *FROM productos WHERE productos.id IN "
					+ "(SELECT carrito_has_product.producto_id FROM "
					+ "carrito_has_product WHERE carrito_has_product.carrito_id = ?1)",
			nativeQuery = true)
	
	public List <Producto> misProductosCarrito (int idCarrito);
	
	
}
