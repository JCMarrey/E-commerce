package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.entity.Compra;


public interface CompraService {
	
	//método que genera la compra, pero que aún no se ha pagado
	public Compra generarCompra(int idCliente, Compra compra, int idProducto);
	
	//método para finalizar la compra y genera el ticket
	
	public void finalizarCompra(int idCompra);
	
	public void cancelarCompra(int idCompra);
	
	//public Compra verDetalleCompra(int idCompra, int idCliente);
	
	//public List <Compra> verCompras (int idCliente);
	
	public ArrayList <Compra> visualizarComprasPendientes(int idUsuario);
	
	public ArrayList<Compra> visualizarComprasCanceladas(int idUsuario);
	
	public ArrayList<Compra> visualizarComprasRealizadas(int idUsuario);
	
}
