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
import com.ecommerce.service.ProductoService;


//devuelve por defecto un objeto JSon
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/producto/api/productos")
public class ProductoController {
	//inyección de dependencia
	
	
	
	@Autowired(required = true)
	private ProductoService productoService;

	//create a new producto
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto p){
		
		//devuelve el código 201 para saber que ha creado con exito un usuario
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(p));
	}
	
	//Read an producto por id 
	@GetMapping("verDetallesProducto/{id}")
	public ResponseEntity <?> read(@PathVariable (value = "id") Integer productoId){
		Optional <Producto> oProducto = productoService.verDetallesProducto(productoId);
		
		//SI no hay un objeto
		if(!oProducto.isPresent()){
			//devuelve un 404 código de error
			return ResponseEntity.notFound().build();
		}	
		//código de estado 200 significa que siempre hay un producto
		return ResponseEntity.ok(oProducto);
	
	}
	
	@GetMapping("buscarProducto/{id}")
	public Producto buscarProducto(@PathVariable (value = "id") Integer productoId){
		Producto oProducto = productoService.buscarProducto(productoId);
		
		return oProducto;
	}
	
	
	//update an product
	@PutMapping("/{id}")
	public ResponseEntity <?> update(@RequestBody Producto p, @PathVariable(value = "id") Integer productoId){
		Optional <Producto> producto = productoService.verDetallesProducto(productoId);
		
		//checar si ha devuelvo algún objeto
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		producto.get().setNombre(p.getNombre());
		//faltan los demás campos, pero no importan.
		
		//estado 201 
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
		
	}
	// delete an producto
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> delete (@PathVariable(value = "id") Integer productoId){
		if(!productoService.verDetallesProducto(productoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
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
	
	@GetMapping("/buscarProductos/{nombre}")
	public List <Producto> buscarProductos(@PathVariable (value = "nombre") String nombre){
		System.out.println("esto es: " + nombre );
		if (nombre != null) {
			System.out.println("esto es: " + nombre );
			productoService.findAll(nombre);
		}
		//personalizas este return para que nos mande algún error
		return productoService.findAll(nombre);
	}

	
	//búsqueda de productos con formato islike para encontrar productos similares

	
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
	

}




