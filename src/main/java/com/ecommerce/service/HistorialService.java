package com.ecommerce.service;

import java.util.ArrayList;

import com.ecommerce.entity.Producto;

public interface HistorialService {

	public ArrayList <Producto> productosBasadosHistorial (int idCliente);
		
}
