// Importaciones necesarias para la clase
package com.ke_detalles.SSENA.entity;

import java.io.Serializable;
import java.util.Date; // Importa Date de java.util en lugar de java.sql

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;



// Definición de la entidad Person
@Entity
@Table(name="persons") // Especifica el nombre de la tabla en la base de datos
public class Person implements Serializable { // Implementa Serializable para soportar serialización
	
	private static final long serialVersionUID = 1L; // Identificador único de la versión serializada
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Genera automáticamente la clave primaria
	@Column(name="id") // Mapea el campo id en la base de datos
	private long id;
	
	@NotBlank // Valida que el campo no esté en blanco
	@Column(name="name") // Mapea el campo name en la base de datos
	private String name;
	
	@Column(name = "address") // Mapea el campo address en la base de datos
	private String address;
	
	@Column(name = "phone") // Mapea el campo phone en la base de datos
	private Integer phone;
	
	@Column(name="created_at") // Mapea el campo created_at en la base de datos
	@CreatedDate // Indica que se generará automáticamente la fecha de creación
	private Date createdAt; // Almacena la fecha de creación de la entidad

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Integer getPhone() {
		return phone;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	// Getters y setters para acceder a los campos privados
}
