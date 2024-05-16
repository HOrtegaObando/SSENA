package com.ke_detalles.SSENA.controller;

import com.ke_detalles.SSENA.entity.Person;
import com.ke_detalles.SSENA.entity.Producto;
import java.util.List;

public class CompraRequest {

    private Person person;
    private List<Producto> producto;
    private int cantidad;

    // Constructor, getters y setters

    public CompraRequest() {
    }

    public CompraRequest(List<Producto> producto, int cantidad, Person person) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}