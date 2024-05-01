package com.ke_detalles.SSENA.controller;

import com.ke_detalles.SSENA.entity.Producto;

public class CompraRequest {

    private Producto producto;
    private int cantidad;

    // Constructor, getters y setters

    public CompraRequest() {
    }

    public CompraRequest(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}