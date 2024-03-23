package com.ke_detalles.SSENA.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ke_detalles.SSENA.dto.LoginRequest;

@RestController
public class AuthController {
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
      

        if (loginRequest.getUsername().equals("usuario") && loginRequest.getPassword().equals("contraseña")) {
            
            return ResponseEntity.ok().build();
        } else {
           
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}