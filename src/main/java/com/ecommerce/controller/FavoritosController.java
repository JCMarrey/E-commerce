package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Producto;
import com.ecommerce.repository.ProductoRepository;
import com.ecommerce.service.FavoritoService;
import com.ecommerce.service.InteraccionService;
import com.ecommerce.service.ProductoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping ("/favoritos/api")
public class FavoritosController {
	
	@Autowired(required = true)
	FavoritoService favoritoService;
	
	@Autowired(required = true)
	ProductoService productoService;
	
	@Autowired(required = true)
	InteraccionService interaccionService;
	
	@Autowired(required = true )
	ProductoRepository productoRepository;
	
	Producto productoEncontrado = new Producto();
	
	@GetMapping("/addItemF/{idUsuario}&{idProducto}")
	public Producto agregarArticuloFavoritos(@PathVariable (value = "idUsuario") Integer idUsuario, @PathVariable (value = "idProducto") Integer idProducto){
		
		System.out.println("idUsuario" + idUsuario);
		System.out.println("idProducto" + idProducto);
		
		
		
		favoritoService.agregarProductoFavorito(idUsuario, idProducto);
	
		productoEncontrado = productoRepository.buscarProducto(idProducto);	
		
		int idFavorito = favoritoService.buscarIDFavoritos(idUsuario).getIdFavoritos();
		
		
		//tabla interna oculta
		interaccionService.guardarFavoritoUsuario(idFavorito, idProducto, idUsuario);
		
		
		
		
		//return "ventana emergente se ha agregado producto a favoritos";
		//se regresa el idUsuario para seguir con la busqueda.
		return productoEncontrado;
	}
	
	@GetMapping("/visualizarFavoritos/{idUsuario}")
	public List <Producto> misFavoritos (@PathVariable (value = "idUsuario") Integer idUsuario){
		
		int idFavorito = favoritoService.buscarIDFavoritos(idUsuario).getIdFavoritos();
		return productoService.misProductosFavoritos(idFavorito);
	}
	@DeleteMapping("/borrarProductoFavorito/{idUsuario}&{idProducto}")
	public List <Producto> borrarProductoFavorito (@PathVariable (value = "idUsuario") int idUsuario,
			@PathVariable (value = "idProducto") int idProducto) {
	//se manda el id del usuario se busca el id de la tabla favoritos y se borra de la tabla favoritos
		
		int idFavorito = favoritoService.buscarIDFavoritos(idUsuario).getIdFavoritos();
		favoritoService.eliminarProductoFavoritoById(idFavorito, idProducto);
		
		//agregar fecha eliminada a la tabla oculta
		
		interaccionService.agregarFechaProductoEliminado(idFavorito, idProducto);
		
		System.out.println("el id del id favorito es:" + idFavorito);
		
		return productoService.misProductosFavoritos(idFavorito);
	}
	
}
