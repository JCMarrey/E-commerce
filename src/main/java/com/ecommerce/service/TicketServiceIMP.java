package com.ecommerce.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Compra;
import com.ecommerce.entity.Producto;
import com.ecommerce.entity.Ticket;
import com.ecommerce.repository.ProductoRepository;
import com.ecommerce.repository.TicketRepository;

@Service
public class TicketServiceIMP  implements TicketService{

	@Autowired(required = true)
	TicketRepository ticketRepository;
	
	@Autowired(required = true)
	ProductoService productoService;
	
	@Autowired(required = true)
	ProductoRepository pR;
	
	@Autowired(required = true)
	ClienteService clienteService;
	
	@Override
	public Boolean generarTicket(Compra compra, Cliente cliente, int idProducto) {		
		
		 // para la fecha de entrega :v
		
		LocalDate localDate = LocalDate.now().plusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
		String fechaEntrega = localDate.format(formatter);
		
		Producto producto = pR.buscarProducto(idProducto);
		
		Ticket t = new Ticket ();
		t.setApellidos(cliente.getApellidos());
		t.setCorreo(cliente.getCorreoElectronico());
		t.setDescripcionProducto(producto.getDescripcion());
		t.setDomicilio(cliente.getDomicilio());
		t.setFechaCompra(compra.getFechaCompra());
		t.setNombreCliente(cliente.getNombreCliente());
		t.setIdCompra(compra.getIdCompra());
		t.setIdCliente(cliente.getIdUsuario());
		t.setNombreProducto(producto.getNombre());
		t.setMontoPagado(compra.getMontoPagado());
		t.setTelefono(cliente.getTelefono());
		t.setFechaEntrega(fechaEntrega);
		t.setEstadoPedido("pendiente");

		ticketRepository.save(t);
		
		return true;
	}

	@Override
	public Ticket obtenerTicket(int idCliente, int idCompra) {
		return ticketRepository.obtenerTicket(idCliente, idCompra);
	}

	@Override
	public void cancelarTicket(int idCompra) {
		ticketRepository.cancelarTicket("Cancelado", idCompra);
		
	}

	@Override
	public void finalizarTicket(int idTicket) {
		ticketRepository.finalizarTicket("Concluido", idTicket);	
	}
	
}
