package com.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Producto;
import com.ecommerce.service.HistorialService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/historial/api")
public class HistorialController {
	
	@Autowired(required = true)
	HistorialService historialService;
	
	@GetMapping("/verHistorialBusquedas/{idCliente}")
	public ArrayList <Producto> verHistorialBusquedas(@PathVariable (value= "idCliente") Integer idCliente){
		
		return historialService.productosBasadosHistorial(idCliente) ;
	}

}
