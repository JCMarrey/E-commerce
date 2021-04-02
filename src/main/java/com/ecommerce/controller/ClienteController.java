package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.entity.Cliente;
import com.ecommerce.service.ClienteService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping ("/clientes/api")
public class ClienteController {

	@Autowired(required = true)
	private ClienteService clienteService;
	
	//registrar usuario
		@PostMapping ("/add")
		public ResponseEntity<Cliente> create(@RequestBody Cliente c){
			
			if ( clienteService.save(c) == null) {
				System.out.println("Error al insertar o cliente existente");
				return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(clienteService.save(c));
				//return "usuario ya existente";
			}
			System.out.println("INSERTADO CON ÉXITO");
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(c));
			//return "usuario: " + c.getNombreUsuario() + " agregado con exito";
		}
	
		@GetMapping("/buscarCliente/{idCliente}")
		public Cliente obtenerDatosCliente (@PathVariable (value = "idCliente") Integer idCliente) {
			Cliente clienteNuevo = clienteService.obtenerDatosCliente(idCliente);
			if(clienteService.obtenerDatosCliente(idCliente)!= null) {
				return clienteNuevo;
			}
			//no hay cliente con ese ID;
			return null;
		}
		
		@PostMapping("/login")
		public int login(@RequestBody Cliente c){
			
			Cliente clienteSesion = clienteService.findClienteSesion(c.getNombreUsuario(),c.getPassword());
			if(clienteSesion == null) {
				//agregar la vista con datos erroneos significa que no hay carrito o algo esta mal en los datos
				return 0;
			}
			
			//buscarIDUsuaario;
			return clienteService.buscarIdUsuario(c.getNombreUsuario());
		}
}
