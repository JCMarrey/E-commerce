package com.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.entity.Cliente;
import com.ecommerce.service.ClienteService;

@RestController
@RequestMapping ("/clientes/api")
public class ClienteController {

	@Autowired(required = true)
	private ClienteService clienteService;
	
	//registrar usuario
		@PostMapping ("/add")
		public String create(@RequestBody Cliente c){
			
			if ( clienteService.save(c) == null) {
				System.out.println("no se pudo insertar");
				//return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(clienteService.save(c));
				return "usuario ya existente";
			}
			System.out.println("INSERTADO CON ÉXITO");
			//return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(c));
			return "usuario: " + c.getNombreUsuario() + " agregado con exito";
		}
	
		@GetMapping("/buscarCliente/{id}")
		public ResponseEntity <?> read(@PathVariable (value = "id") Integer clienteId){
			Optional <Cliente> oCliente = clienteService.findById(clienteId);
			
			//SI no hay un objeto
			if(!oCliente.isPresent()){
				//devuelve un 404 código de error
				return ResponseEntity.notFound().build();
			}	
			return ResponseEntity.ok(oCliente);
		}
		
		@PostMapping("/login/{nombreUsuario}&{password}")
		public String login(@PathVariable (value = "nombreUsuario") String nombreUsuario, @PathVariable
				(value = "password") String password){
			
			Cliente clienteSesion = clienteService.findClienteSesion(nombreUsuario,password);
			if(clienteSesion == null) {
				//agregar la vista con datos erroneos
				return "error verificar campos";
			}
			//hay que buscar al carrito correspondiente a nuestro cliente que ya inicio sesión
			
			int idCarrio = clienteService.buscarCarritoUsuario(nombreUsuario);
				//continuar con la vista generar de productos
			return " urlListaProductos " + " idCarrio: " + String.valueOf(idCarrio) + " userName ="+ nombreUsuario;
		}
}
