package com.ke_detalles.SSENA.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nombre;

	    private int cantidadDisponible;

	    private double precio;

	    // Constructor vacío
	    public Producto() {
	    }

	    // Constructor con parámetros
	    public Producto(String nombre, int cantidadDisponible, double precio) {
	        this.nombre = nombre;
	        this.cantidadDisponible = cantidadDisponible;
	        this.precio = precio;
	    }

	    // Getters y setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getCantidadDisponible() {
	        return cantidadDisponible;
	    }

	    public void setCantidadDisponible(int cantidadDisponible) {
	        this.cantidadDisponible = cantidadDisponible;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }

}
