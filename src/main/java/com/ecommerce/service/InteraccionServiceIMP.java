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
		interaccionRepository.save(null);
	}



	@Override
	public void agregarFechaProductoEliminado(int idFavorito) {
		SimpleDateFormat fechaEliminar = new SimpleDateFormat("dd-MM-YYYY");
		String fechaBorrar = fechaEliminar.format(new Date());
		
		
		interaccionRepository.agregarFechaProductoEliminado(fechaBorrar, idFavorito);	
		System.out.println("la fecha eliminada se ha modificado por.." + fechaBorrar  + "id favorito" + 
				idFavorito);
		
	}



	@Override
	public void guardarFavoritoUsuario(int id_favoritos, int id_producto,
			int id_usuario) {
		this.favoritoInteraccion.setIdFavorito(id_usuario);
		this.favoritoInteraccion.setIdProducto(id_producto);
		this.favoritoInteraccion.setIdUsuario(id_usuario);
		this.favoritoInteraccion.setFechaEliminado(null);
		interaccionRepository.save(favoritoInteraccion);
		
		
	}
	
	

}
