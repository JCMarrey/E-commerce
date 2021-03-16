package com.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.entity.Producto;
import com.ecommerce.service.BusquedaService;
import com.ecommerce.service.CarritoService;
import com.ecommerce.service.ProductoService;

//esto controlador no se usa aún... todo es a través del controllador de carrito

@RestController
@RequestMapping ("/carrito/api")
public class CarritoController {
	
	@Autowired(required = true)
	private CarritoService carritoService;
	
	@Autowired(required = true)
	private ProductoService productoService;
	
	@Autowired(required = true)
	private BusquedaService busquedaService;
	
	@PostMapping("/addItem/{idCarrito}&{idProducto}")
	public String addItemToCarrito(@PathVariable (value = "idProducto") Integer idProducto, @PathVariable (value = "idCarrito") Integer idCarrito){
		
		//buscar el carrito de compras 
		if(carritoService.agregarProductoCarrito(idCarrito, idProducto) == null) {
			return "hubo un error al agregar el producto";
		}
		/*buscar id del usuario para poder mandarlo y que este quede registrado en tabla reviews*/
		
		
		int idUsuario = busquedaService.buscarUsuarioCarrito(idCarrito);
		busquedaService.agregarProductoCarrito(idCarrito, idProducto, idUsuario);
		System.out.println("EL ID DEL USUARIO ES:..." + idUsuario);
		return "producto agregado con éxito " + "mostrar carrito"; 
	}
	
	//método para visualizar productos del carrito
	@GetMapping("/miCarrito/{idCarrito}")
	public List <Producto> miCarrito (@PathVariable (value = "idCarrito") Integer idCarrito){
		return productoService.misProductosCarrito(idCarrito);
	}
	
	//método para eliminar un producto del carrito
	@DeleteMapping("/borrarProductoCarrito/{idCarrito}&{idProducto}")
	public String borrarProductoCarrito (@PathVariable (value = "idCarrito") int idCarrito, @PathVariable
	(value = "idProducto") int idProducto) {
		
		//carritoService.eliminarProductoCarritoById(idCarrito, idProducto);
		busquedaService.agregarFechaProductoEliminado(idCarrito);
		return "producto con id: "+ idProducto + " eliminado .. recargar página con prpductos restantes" ;
	}

}
