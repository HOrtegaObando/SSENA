package com.ke_detalles.SSENA.servicio;

import com.ke_detalles.SSENA.controller.CompraRequest;
import com.ke_detalles.SSENA.entity.Producto;
import com.ke_detalles.SSENA.entity.Compra;


public interface CompraService {
    public Compra realizarCompra(CompraRequest compraRequest);
    public void actualizarCantidadDisponible(Producto producto, int cantidad);
    
}