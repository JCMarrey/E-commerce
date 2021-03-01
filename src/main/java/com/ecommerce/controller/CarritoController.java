package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Producto;
import com.ecommerce.service.CarritoService;

@RestController
@RequestMapping ("/carrito/api")
public class CarritoController {
	
	@Autowired(required = true)
	private CarritoService carritoService;

	@PostMapping("/addItem/{idCarrito}")
	public String addItemToCarrito(@RequestBody Producto p, @PathVariable (value = "idCarrito") Integer idCarrito){
		
		Carrito carritoAdd = new Carrito (idCarrito);
		
		if(carritoService.agregarProductoCarrito(carritoAdd, p) == null) {
			return "hubo un error al agregar el producto";
		}
		return "producto agregado con éxito " + "mostrar carrito"; 
	}
	
	//método para visualizar productos del carrito
	@GetMapping("/miCarrito")
	public List <Producto> miCarrito (){
		
		return null;
	}
	
	//método para eliminar un producto del carrito
}
