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
import com.ecommerce.service.BusquedaService;
import com.ecommerce.service.CarritoService;
import com.ecommerce.service.ProductoService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping ("/carrito/api")
public class CarritoController {
	
	@Autowired(required = true)
	private CarritoService carritoService;
	
	
	@Autowired(required = true)
	private BusquedaService busquedaService;
	
	@Autowired(required = true)
	private ProductoService productoService;

	
	@GetMapping("/addItem/{idCarrito}&{idProducto}")
	public Producto addItemToCarrito(@PathVariable (value = "idProducto") Integer idProducto, @PathVariable (value = "idCarrito") Integer idCarrito){
		
		//buscar el carrito de compras 
		if(carritoService.agregarProductoCarrito(idCarrito, idProducto) == null) {
			return null; //mandar mensaje de erroor al agregar
		}
		/*buscar id del usuario para poder mandarlo y que este quede registrado en tabla reviews*/
		int idUsuario = busquedaService.buscarUsuarioCarrito(idCarrito);
		busquedaService.agregarProductoCarrito(idCarrito, idProducto, idUsuario);
		
		//esto sirve para mostrar la información del producto así como en mercado libre.
		
		Producto oProducto = productoService.buscarProducto(idProducto);
		//estoo se puede cambiar por String para mandar una URL y quizás después el objeto JSON:"
		
		/*"\"producto agregado..\" + \" los datos del producto son:\" + oProducto.getNombre() + \"\\n\"\r\n"
		+ "				+oProducto.getDescripcion();	*/
		System.out.println("producto agregado con éxito...");
		return oProducto;
	}
	
	//método para visualizar productos del carrito
	@GetMapping("/miCarrito/{idCarrito}")
	public List <Producto> miCarrito (@PathVariable (value = "idCarrito") Integer idCarrito){
		return productoService.misProductosCarrito(idCarrito);
	}
	
	//método para eliminar un producto del carrito
	@DeleteMapping("/borrarProductoCarrito/{idCarrito}&{idProducto}")
	public List <Producto> borrarProductoCarrito (@PathVariable (value = "idCarrito") int idCarrito, @PathVariable
	(value = "idProducto") int idProducto) {
		
		
	carritoService.eliminarProductoCarritoById(idCarrito, idProducto);	
	
	//este método solo modifica la fecha de eliminación de la tabla oculta.
	busquedaService.agregarFechaProductoEliminado(idCarrito);
	System.out.println("producto eliminado con éxito... y mostrar los restantes productos");
	return productoService.misProductosCarrito(idCarrito);
	}

}
