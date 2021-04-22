package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Ticket;

@Repository
public interface TicketRepository  extends JpaRepository <Ticket, Integer> {


	
	@Query(
			value = "SELECT * FROM tickets WHERE tickets.id_cliente = ?1 AND tickets.id_compra = ?2  ",
			nativeQuery = true)
	public Ticket obtenerTicket (int idCliente, int idCompra);
	

	@Modifying
	@Transactional 
	@Query(value = "UPDATE tickets SET estado_pedido =?1 where tickets.id_compra =?2",
	           nativeQuery = true)
	public void cancelarTicket (String accion, int idCompra);
	
	@Modifying
	@Transactional 
	@Query(value = "UPDATE tickets SET estado_pedido =?1 where tickets.id_compra =?2",
	           nativeQuery = true)
	
	public void finalizarTicket (String estado,int idTicket);
	
}
