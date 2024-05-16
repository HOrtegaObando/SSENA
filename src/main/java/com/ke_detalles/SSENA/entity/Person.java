package com.ke_detalles.SSENA.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// Remove unnecessary import
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "persons")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    // Relación uno-a-varios con Compra
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Compra> compras;

    // Relación uno-a-muchos con User (opcional)
    @OneToOne // Replace with @ManyToOne if you have a User entity
    @JoinColumn(name = "user_id") // Optional for ManyToOne
    private User user;  // Replace with your User class if applicable
 
    // Getters
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

    public User getUser() {
        return user;
    }

    // Setters
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

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public void setUser(User newUser) {
        this.user = newUser;
    }

    // Getters and Setters for compras (Optional)
    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}