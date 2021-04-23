package com.ecommerce.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Producto;
import com.ecommerce.repository.HistorialRepository;

@Service
public class HistorialServiceIMP  implements HistorialService {

	@Autowired(required = true)
	HistorialRepository historialRepository;
	
	@Override
	public ArrayList<Producto> productosBasadosHistorial(int idCliente) {
		return historialRepository.productosBasadosHistorial(idCliente);
	}

}
