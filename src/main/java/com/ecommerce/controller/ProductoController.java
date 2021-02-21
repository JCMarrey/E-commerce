package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	//inyección de dependencia
	
	@Autowired
	private ProductoService productoService;
	
	//create a new producto
	@PostMapping
	//mandar el producto
	public ResponseEntity<?> create(@RequestBody Producto p){
		
		//devuelve el código 201 para saber que ha creado con exito un usuario
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(p));
	}
	
	//Read an producto por id 
	@GetMapping("/{id}")
	public ResponseEntity <?> read(@PathVariable (value = "id") Integer userId){
		Optional <Producto> oProducto = productoService.findById(userId);
		
		//SI no hay un objeto
		if(!oProducto.isPresent()){
			//devuelve un 404 código de error
			return ResponseEntity.notFound().build();
		}	
		//código de estado 200 significa que siempre hay un producto
		return ResponseEntity.ok(oProducto);
	
	}
	//update an product
	@PutMapping("/{id}")
	public ResponseEntity <?> update(@RequestBody Producto p, @PathVariable(value = "id") Integer productoId){
		Optional <Producto> producto = productoService.findById(productoId);
		
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity <?> delete (@PathVariable(value = "id") Integer productoId){
		if(!productoService.findById(productoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoService.deleteById(productoId);
		return ResponseEntity.ok().build();
	}
	
	//leer todos los productos
	@GetMapping
	public List<Producto> readAll(){
		//transformación de objeto iterable a una lista
		List<Producto> listaProductos = StreamSupport
				.stream(productoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return listaProductos;		
	}
}
