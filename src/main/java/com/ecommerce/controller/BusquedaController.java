package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.service.BusquedaService;
//controlador para poder agregar las preferencias de los usuarios y no perder nada

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping ("/carritoOculto/api")
public class BusquedaController {
	
	@Autowired(required = true)
	private BusquedaService busquedaService;
	
	@PostMapping("/addItem/{idCarrito}&{idProducto}")
	public String addItemToCarrito(@PathVariable (value = "idProducto") Integer idProducto, @PathVariable (value = "idCarrito") Integer idCarrito){
		
		System.out.println("id producto = " + idProducto);
		//buscar el carrito de compras 
		if(busquedaService.agregarProductoCarrito(idCarrito, idProducto,0) == null) {
			return "hubo un error al agregar el producto";
		}
		return "el usuario ha agregado un producto al carrito no se puede eliminar esta tabla "+ idProducto + "mostrar carrito"; 
	}
	
	@GetMapping("/busquedas/usuario{busqueda}&{idUsuario}")
	public void guardarBusquedaUsuario(@PathVariable(value = "busqueda") String busqueda,@PathVariable (value = "idUsuario") Integer idUsuario) {
	
		busquedaService.guardarBusquedaUsuario(busqueda,idUsuario);
	}
	
}
