package com.ecommerce.service;

public interface InteraccionService {

	public void verDetallesProductoInteraccion(int idCliente, int idProducto);
	
	public void agregarFechaProductoEliminado (int idFavorito);
	
	public void guardarFavoritoUsuario(int	id_favoritos, int 	id_producto , int	id_usuario );
	
}
