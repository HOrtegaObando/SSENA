// Importación de las clases necesarias
package com.ke_detalles.SSENA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ke_detalles.SSENA.entity.Person; // Importación de la entidad person

// Anotación que indica que esta interfaz es un repositorio de Spring
@Repository
// Interfaz que extiende JpaRepository para realizar operaciones CRUD en la entidad person

public interface PersonDao extends JpaRepository<Person, Long> {

}