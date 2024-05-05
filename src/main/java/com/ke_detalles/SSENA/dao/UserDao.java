package com.ke_detalles.SSENA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ke_detalles.SSENA.entity.User;



@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
    @Query(value = "SELECT * FROM users WHERE username = ?1 AND password = ?2", nativeQuery = true)
    User findByUserAndPassword(String username, String password);
}

