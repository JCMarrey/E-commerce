package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.service.FavoritoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping ("/favoritos/api")
public class FavoritosController {
	
	@Autowired(required = true)
	FavoritoService favoritoService;
	
	@GetMapping("/addItemF/{idUsuario}&{idProducto}")
	public String agregarArticuloFavoritos(@PathVariable (value = "idProducto") Integer idProducto, @PathVariable (value = "idUsuario") Integer idUsuario){
		
		
		int idCarritoF =  favoritoService.buscarIDFavoritos(idUsuario);
		
			
		  
		 
		
		
		return "ventana emergente se ha agregado producto a favoritos";
		
	}
}
