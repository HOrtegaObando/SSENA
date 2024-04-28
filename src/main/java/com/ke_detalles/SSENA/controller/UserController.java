/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ke_detalles.SSENA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ke_detalles.SSENA.entity.User;
import com.ke_detalles.SSENA.services.Userservice;




@RestController
public class UserController {
    
    @Autowired
    private Userservice userService;
    
    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody User signupRequest) {
       
        if (userService.findUserByAccount(signupRequest.getUsername()) != null) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya está en uso");
        }
        
        
        User newUser = new User();
        newUser.setUsername(signupRequest.getUsername());
        newUser.setPassword(signupRequest.getPassword()); 
      
        User savedUser = userService.saveUser(newUser);
        
        
        return ResponseEntity.ok(savedUser);
    }
}