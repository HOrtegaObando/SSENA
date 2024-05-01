package com.ke_detalles.SSENA.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Compra {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "producto_id", nullable = false)
	    private Producto producto;
	    
	    private int cantidad;

	    private BigDecimal precioTotal;

	    private LocalDateTime fechaCompra;

	    // Constructor vacío
	    public Compra() {
	    }

	    // Constructor con parámetros
	    
	    public Compra(Producto producto, int cantidad, BigDecimal precioTotal, LocalDateTime fechaCompra) {
	        this.producto = producto;
	        this.cantidad = cantidad;
	        this.precioTotal = precioTotal;
	        this.fechaCompra = fechaCompra;
	    }

	    // Getters y setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
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

	    public BigDecimal getPrecioTotal() {
	        return precioTotal;
	    }

	    public void setPrecioTotal(BigDecimal precioTotal) {
	        this.precioTotal = precioTotal;
	    }

	    public LocalDateTime getFechaCompra() {
	        return fechaCompra;
	    }

	    public void setFechaCompra(LocalDateTime fechaCompra) {
	        this.fechaCompra = fechaCompra;
	    }

}
