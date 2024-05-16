package com.ke_detalles.SSENA.controller;

import com.ke_detalles.SSENA.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ke_detalles.SSENA.entity.User;
import com.ke_detalles.SSENA.services.Userservice;
import com.ke_detalles.SSENA.services.personservice;
import java.util.Date;
import org.springframework.web.bind.annotation.CrossOrigin;



@RestController
@CrossOrigin
public class UserController {
    
    @Autowired
    private Userservice userService;
    
    @Autowired
    private personservice personService;
    
    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody Person signupRequest) {
    	//verifico si el nombre de usuario está en uso
        if (userService.findUserByAccount(signupRequest.getUser().getUsername()) != null) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya está en uso");
        }
        if (!signupRequest.getUser().getPassword().equals(signupRequest.getUser().getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Las contraseñas no coinciden");
        }
        
        Person person = new Person();
        person.setAddress(signupRequest.getAddress());
        person.setName(signupRequest.getName());
        person.setCreatedAt(new Date());
        person.setPhone(signupRequest.getPhone());
        
        User newUser = new User();
        newUser.setUsername(signupRequest.getUser().getUsername());
        newUser.setPassword(signupRequest.getUser().getPassword());
        
        person.setUser(newUser);
      
        Person savedPerson = personService.save(person);
        
        return ResponseEntity.ok(savedPerson);
       
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User userRequest) {
        User user = userService.getUserAndPassword(userRequest);
        if (userService.getUserAndPassword(userRequest) == null) {
            return ResponseEntity.badRequest().body("Usario o contraseña no coinciden");
        }
        
        return ResponseEntity.ok(user);
       
    }
}