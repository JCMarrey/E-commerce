package com.ecommerce;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import com.ecommerce.entity.Carrito;
import com.ecommerce.entity.Producto;
import com.ecommerce.repository.CarritoRepository;
*/

//implements CommandLineRunner

@SpringBootApplication(scanBasePackages={"com.ecommerce.controller", "com.ecommerce.entity","com.ecommerce.model",
"com.ecommerce.repository","com.ecommerce.service","com.prueba"})
public class PruebaApplication  {
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
/*
	@Autowired
	private CarritoRepository carritoRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Carrito carrito = new Carrito ((float) 45.5);
		Producto producto = new Producto ("producto1","chetos");
		Producto producto2 = new Producto ("producto2","rufles");
		
				
				
		//agregar los productos que están en el carrito
		carrito.getProductos().add(producto);
		carrito.getProductos().add(producto2);
		
		//add el carrito que referencia a los productos
		
		producto.getCarrito().add(carrito);
		producto.getCarrito().add(carrito);
		
		this.carritoRepository.save(carrito);
		
	}*/
}
