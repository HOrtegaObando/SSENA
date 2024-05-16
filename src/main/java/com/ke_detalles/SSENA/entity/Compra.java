package com.ke_detalles.SSENA.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "person_id", nullable = false) // Modifica el nombre de la columna si es necesario
  private Person person;  // Propiedad para la relación uno-a-varios

  @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
  private List<Producto> producto;

  @Column(name = "precio_total")
  private BigDecimal precioTotal;

  @Column(name = "fecha_compra")
  private LocalDateTime fechaCompra;

  // Constructor vacío
  public Compra() {
  }

  // Constructor con parámetros

  public Compra(List<Producto> producto, BigDecimal precioTotal, LocalDateTime fechaCompra, Person person) {
    this.person = person;
    this.producto = producto;
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