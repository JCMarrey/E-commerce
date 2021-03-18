package com.ecommerce.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.BusquedaCliente;
import com.ecommerce.entity.CarritoUsuarioBusqueda;
import com.ecommerce.repository.BusquedaRepository;

@Service
public class BusquedaServiceIMP  implements BusquedaService{

	@Autowired(required = true)
	BusquedaRepository busquedaRepository;
	
	private CarritoUsuarioBusqueda carritoUsuarioB = new CarritoUsuarioBusqueda ();
	
	
	private BusquedaCliente busquedaCliente;
	
	@Transactional
	@Override
	public CarritoUsuarioBusqueda agregarProductoCarrito(int idCarrito, int idProducto, int idUsuario) {
		
		//hasta el momento la acción es agregar por eso fecha eliminado va en null
		this.carritoUsuarioB.setFechaEliminado(null);
		this.carritoUsuarioB.setIdCarrito(idCarrito);
		this.carritoUsuarioB.setIdProducto(idProducto);
		this.carritoUsuarioB.setIdUsuario(idUsuario);
		
		System.out.println("estamos dentro de la tabla oculta...");
		
		
		return busquedaRepository.save(carritoUsuarioB);
	}

	@Override
	public int buscarUsuarioCarrito(int idCarrito) {
		return busquedaRepository.buscarUsuarioCarrito(idCarrito);
	}

	@Override
	public void agregarFechaProductoEliminado(int idCarrito) {
		
		Date fechaEliminar = new Date ();
		busquedaRepository.agregarFechaProductoEliminado(fechaEliminar, idCarrito);
		System.out.println("la fecha eliminada se ha modificado por.." + fechaEliminar  + "id carrotp" + idCarrito);
	}

	@Override
	public void guardarBusquedaUsuario(String busqueda, int idUsuario) {

		busquedaCliente = new BusquedaCliente ();
		String fechaBusqueda = busquedaCliente.obtenerFechaBusqueda();
		String horaBusqueda = busquedaCliente.obtenerHoraBusqueda();
		busquedaRepository.guardarBusquedaUsuario(busqueda, fechaBusqueda, horaBusqueda, idUsuario);
		
	}
}
