package com.ke_detalles.SSENA.servicio;

import com.ke_detalles.SSENA.entity.Producto;
import com.ke_detalles.SSENA.entity.Compra;


public interface CompraService {
    Compra realizarCompra(Producto producto, int cantidad);
    void actualizarCantidadDisponible(Producto producto, int cantidad);
    
}