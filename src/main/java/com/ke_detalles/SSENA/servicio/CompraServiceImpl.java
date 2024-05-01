package com.ke_detalles.SSENA.servicio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ke_detalles.SSENA.entity.Compra;
import com.ke_detalles.SSENA.entity.Producto;

public class CompraServiceImpl implements CompraService {

    @Override
    public Compra realizarCompra(Producto producto, int cantidad) {
        /* Implementación de la lógica para realizar la compra
        Por ejemplo, puedes crear una nueva instancia de Compra con los parámetros proporcionados
         y devolverla*/
    	Compra compra = new Compra(
    		    producto,
    		    cantidad,
    		    calcularPrecioTotal(BigDecimal.valueOf(producto.getPrecio()), cantidad),
    		    LocalDateTime.now()
    	);
        return compra;
    }

    @Override
    public void actualizarCantidadDisponible(Producto producto, int cantidad) {
        /* Implementación de la lógica para actualizar la cantidad disponible del producto*/
        
    }

    /* Método auxiliar para calcular el precio total de la compra*/
    private BigDecimal calcularPrecioTotal(BigDecimal precioUnitario, int cantidad) {
        BigDecimal cantidadBigDecimal = BigDecimal.valueOf(cantidad);
        return precioUnitario.multiply(cantidadBigDecimal);
    }
    
}