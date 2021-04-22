package com.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Compra;
import com.ecommerce.entity.Producto;
import com.ecommerce.entity.Ticket;
import com.ecommerce.repository.ProductoRepository;
import com.ecommerce.repository.TicketRepository;
import com.ecommerce.service.ClienteService;
import com.ecommerce.service.CompraService;
import com.ecommerce.service.ProductoService;
import com.ecommerce.service.TicketService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping ("/compras/api")
public class CompraController {
	
	@Autowired(required = true)
	CompraService compraService;
	
	@Autowired(required = true)
	ClienteService clienteService;
	
	@Autowired(required = true)
	ProductoService productoService;
	
	@Autowired(required = true)
	TicketService ticketService;
	
	@Autowired(required = true)
	ProductoRepository productoRepository;
	
	@Autowired(required = true)
	TicketRepository ticketRepository;
	
	//@PostMapping("/finalizarCompra/{idCliente}&{idProducto}")
	@RequestMapping(method=RequestMethod.POST, value = "/finalizarCompra")
	public Optional<Ticket> finalizarCompra (@RequestBody Ticket ticket) {
		
		compraService.finalizarCompra(ticket.getIdCompra());
		ticketService.finalizarTicket(ticket.getIdTicket());
		
		System.out.println("felicidades su pedido estará en camino...");
		
		return ticketRepository.findById(ticket.getIdCliente());
	}
	@RequestMapping(method=RequestMethod.POST, value = "/generarCompra/{idCliente}&{idProducto}")
	public ResponseEntity <Ticket> generarCompra (@RequestBody Compra compra, @PathVariable (value = "idCliente") Integer idCliente,
			@PathVariable (value = "idProducto") Integer idProducto) {
		
			Cliente clienteEncontrado = clienteService.obtenerDatosCliente(idCliente);
			Compra compraGenerada = compraService.generarCompra(idCliente, compra, idProducto);
			ticketService.generarTicket(compraGenerada, clienteEncontrado, idProducto);
			return new ResponseEntity <Ticket>(ticketService.obtenerTicket(idCliente, compra.getIdCompra()),HttpStatus.OK);
	}
	
	@GetMapping("/cancelarCompra/{idCompra}")
	public void cancelarCompra (@PathVariable (value = "idCompra") Integer idCompra) {
		compraService.cancelarCompra(idCompra);
		ticketService.cancelarTicket(idCompra);
	}
	

	


}
