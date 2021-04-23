package com.ecommerce.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Compra;
import com.ecommerce.entity.Producto;
import com.ecommerce.repository.CompraRepository;

@Service
public class CompraServiceIMP implements CompraService {
	
	@Autowired(required = true)
	CompraRepository compraRepository;
	
	public String fechaCompra() {
		SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-YYYY");
		String fechaAgregar = fecha.format(new Date());
		return fechaAgregar;
	}
	
	public String horaCompra () {
		SimpleDateFormat horaActualS = new SimpleDateFormat("hh:mm:ss");
		String horaActual = horaActualS.format(new Date());
		
		return horaActual;
	}
	
	public int guardarCompraTablaInterna (int idCliente, String horaActual, int idProducto, Compra compra) {
		int idCompra = compraRepository.obtenerIdCompraHasProducto(idCliente,horaActual);
		compraRepository.agregarCompraHasProducto(idCompra, idProducto);
		compra.setIdCompra(idCompra);
		
		return idCompra;
	}
	
	@Override
	public Compra generarCompra(int idCliente, Compra compra, int idProducto) {
		String horaActual = this.horaCompra();
		
		compra.setEstadoCompra("Pendiente");
		compra.setFechaCompra(this.fechaCompra());
		compra.setHoraCompra(horaActual);
		compra.setIdUsuario(idCliente);
		//insertar compra tanto en tabla compras 
		
		compraRepository.save(compra);

		//insertar compra en tabla interna
			
		this.guardarCompraTablaInterna(idCliente, horaActual, idProducto, compra);
		//regresar compra para generar un pre-ticket
		return compra;
	}

	@Override
	public void finalizarCompra( int idCompra) {
		compraRepository.finalizarCompra("Concluido", idCompra);
	}

	@Override
	public void cancelarCompra(int idCompra) {
		compraRepository.cancelarCompra("Cancelado", idCompra);
	}


	@Override
	public ArrayList<Compra> visualizarComprasPendientes(int idUsuario) {
		
		return compraRepository.visualizarComprasPendientes(idUsuario, "Pendiente");
	}

	@Override
	public ArrayList<Compra> visualizarComprasCanceladas(int idUsuario) {
		
		return compraRepository.visualizarComprasCanceladas(idUsuario, "Cancelado");
	}

	@Override
	public ArrayList<Compra> visualizarComprasRealizadas(int idUsuario) {
		
		return compraRepository.visualizarComprasRealizadas(idUsuario, "Concluido");
	}

}
