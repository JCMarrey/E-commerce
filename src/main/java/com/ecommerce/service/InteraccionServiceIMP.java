package com.ecommerce.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.FavoritoUsuarioInteraccion;
import com.ecommerce.entity.Interaccion;
import com.ecommerce.repository.InteracccionRepository;

@Service
public class InteraccionServiceIMP implements InteraccionService {

	@Autowired(required = true)
	InteracccionRepository interaccionRepository;
	
	private FavoritoUsuarioInteraccion favoritoInteraccion = new FavoritoUsuarioInteraccion ();
	
	@Override
	public void verDetallesProductoInteraccion(int idCliente, int idProducto) {
		
		
		//recuperamos la fecha
		Interaccion interaccion = new Interaccion ();
		String fechaInteraccion = interaccion.getFechaBusqueda();
		String horaInteraccion = interaccion.getHoraBusqueda();
		
		
		//ahora si instanciamos el objeto
		interaccion.setFechaBusqueda(fechaInteraccion);
		interaccion.setHoraBusqueda(horaInteraccion);
		interaccion.setIdCliente(idCliente);
		interaccion.setIdProducto(idProducto);
		
		interaccionRepository.guardarInteraccionProducto(fechaInteraccion,horaInteraccion, idCliente, idProducto);
	}



	@Override
	public void agregarFechaProductoEliminado(int idFavorito, int idProducto) {
		SimpleDateFormat fechaEliminar = new SimpleDateFormat("dd-MM-YYYY");
		String fechaBorrar = fechaEliminar.format(new Date());
		
		
		interaccionRepository.agregarFechaProductoEliminado(fechaBorrar, idFavorito, idProducto);	
		System.out.println("la fecha eliminada se ha modificado por.." + fechaBorrar  + "id favorito" + 
				idFavorito);	
	}
	@Override
	public void guardarFavoritoUsuario(int id_favoritos, int id_producto,
			int id_usuario) {
		
		SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-YYYY");
		String fechaAgregar = fecha.format(new Date());
		
		
		this.favoritoInteraccion.setFechaAgregado(fechaAgregar);
		this.favoritoInteraccion.setIdFavorito(id_favoritos);
		this.favoritoInteraccion.setIdProducto(id_producto);
		this.favoritoInteraccion.setIdUsuario(id_usuario);
		this.favoritoInteraccion.setFechaEliminado(null);
		interaccionRepository.guardarInteraccionUsuario(fechaAgregar, "", id_favoritos, id_producto, id_usuario);
		
	}

}
