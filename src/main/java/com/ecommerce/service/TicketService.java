package com.ecommerce.service;

import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Compra;
import com.ecommerce.entity.Producto;
import com.ecommerce.entity.Ticket;

public interface TicketService {
	
	public Boolean generarTicket (Compra compra, Cliente cliente, int producto);
	
	public Ticket obtenerTicket (int idCliente, int idCompra);
	
	public void cancelarTicket (int idCompra);
	
	public void finalizarTicket (int idTicket);
	
}
