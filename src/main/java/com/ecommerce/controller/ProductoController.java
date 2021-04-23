package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.entity.Producto;
import com.ecommerce.service.BusquedaService;
import com.ecommerce.service.InteraccionService;
import com.ecommerce.service.ProductoService;


//devuelve por defecto un objeto JSon
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/producto/api/productos")
public class ProductoController {
	//inyección de dependencia
	
	@Autowired(required = true)
	private ProductoService productoService;
	
	@Autowired(required = true)
	private BusquedaService busquedaService;
	
	@Autowired(required = true)
	private InteraccionService interaccionService;

	//create a new producto
	@PostMapping("/add")
	public ResponseEntity<?> create(@RequestBody Producto p){
		
		//devuelve el código 201 para saber que ha creado con exito un producto
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(p));
	}
	
	//Read an producto por id 
	@GetMapping("verDetallesProducto/{idProducto}&{idCliente}")
	public Producto Producto (@PathVariable (value = "idProducto") Integer idProducto,
			@PathVariable (value = "idCliente") Integer idCliente){
	
		//Optional <Producto> oProducto = productoService.verDetallesProducto(idProducto);
		
		Producto productoEncontrado = productoService.buscarProducto(idProducto);
		
		//sirve también para saber cuándo un usuario esta encima de un objeto por 40 segundos.
		
		interaccionService.verDetallesProductoInteraccion(idCliente, productoEncontrado.getId());
	
		return productoEncontrado;		
	}
	
	@GetMapping("buscarProducto/{id}")
	public Producto buscarProducto(@PathVariable (value = "id") Integer productoId){
		Producto oProducto = productoService.buscarProducto(productoId);
		
		return oProducto;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> delete (@PathVariable(value = "id") Integer productoId){
		productoService.deleteById(productoId);
		return ResponseEntity.ok().build();
	}
	
	//leer todos los productos
	@GetMapping("/readAll")
	public List<Producto> readAll(){
		//transformación de objeto iterable a una lista
		List<Producto> listaProductos = StreamSupport
				.stream(productoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return listaProductos;		
	}
	
	//búsqueda de productos con formato islike para encontrar productos similares

	@GetMapping("/buscarProductos/{nombre}&{idUsuario}")
	public List <Producto> buscarProductos(@PathVariable (value = "nombre") String nombre, @PathVariable (value = "idUsuario") int idCliente){
		System.out.println("esto es: " + nombre );
		if (nombre != null) {  //no escribio nada
			System.out.println("esto es: " + nombre );
			productoService.findAll(nombre);
		}
		
		//se agrega el registro d ela busqueda a la tabla busquedaCliente
		busquedaService.guardarBusquedaUsuario(nombre, idCliente);
		
		//personalizas este return para que nos mande algún error
		return productoService.findAll(nombre);
	}
	public List <Producto> misProductosCarrito(int idCarrito){
		return productoService.misProductosCarrito(idCarrito);
	}
	
	//Buscar productos por categoria
	@GetMapping("/productos-categoria/{categoria}")
	public List <Producto> productosCategoria(@PathVariable (value="categoria") String categoria){
		
		if(categoria != null){
			return productoService.findProductosCategoria(categoria);
		}
		return productoService.findProductosCategoria(categoria);
		
	}
	
	//método para enlistar todas las categorias
	
	
	
	
	
	
}




