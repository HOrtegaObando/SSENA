package com.ke_detalles.SSENA.servicio;

import com.ke_detalles.SSENA.controller.CompraRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ke_detalles.SSENA.entity.Compra;
import com.ke_detalles.SSENA.entity.Producto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {

    @Override
    public Compra realizarCompra(CompraRequest compraRequest) {
        /* Implementación de la lógica para realizar la compra
        Por ejemplo, puedes crear una nueva instancia de Compra con los parámetros proporcionados
         y devolverla*/
        
    	Compra compra = new Compra(
    		    compraRequest.getProducto(),
    		    calcularPrecioTotal(compraRequest.getProducto()),
    		    LocalDateTime.now(),compraRequest.getPerson()
    	);
        return compra;
    }

    @Override
    public void actualizarCantidadDisponible(Producto producto, int cantidad) {
        /* Implementación de la lógica para actualizar la cantidad disponible del producto*/
        
    }

    /* Método auxiliar para calcular el precio total de la compra*/
    private BigDecimal calcularPrecioTotal(List<Producto> producto) {
        
        double sumPrecio = 0.0; 
        for (Producto item : producto) {
            sumPrecio = sumPrecio + (item.getPrecio()*item.getCantidadSeleccionada());
        }
        
        BigDecimal cantidadBigDecimal = BigDecimal.valueOf(sumPrecio);
        return cantidadBigDecimal;
    }
    
}