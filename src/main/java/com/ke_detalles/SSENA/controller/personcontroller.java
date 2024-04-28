package com.ke_detalles.SSENA.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ke_detalles.SSENA.entity.Person;

import com.ke_detalles.SSENA.services.personservice;

@RestController
@RequestMapping("/api/v1")
public class personcontroller {
	
	@Autowired
	private personservice personService;
	
	@GetMapping(value="/persons")
	public ResponseEntity<Object> get(){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Person> list  = personService.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	
	}

	@GetMapping(value="/persons/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id){ 
		try {
			Person data  = personService.findById(id);
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		} 
		catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
	
	@PostMapping(value="/persons")
	public ResponseEntity<Object> create(@RequestBody Person Person){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Person res = personService.save(Person);  
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
	
	@PutMapping("/persons/{id}")
	public ResponseEntity<Object> update(@RequestBody Person updatedPerson, @PathVariable Long id){ 
	    Map<String, Object> map = new HashMap<String, Object>();
	    try {
	        // Buscar la persona actual en la base de datos
	        Person currentPerson = personService.findById(id);
	        
	        // Actualizar los campos de la persona actual con los valores de la persona actualizada
	        currentPerson.setName(updatedPerson.getName());
	        currentPerson.setAddress(updatedPerson.getAddress());
	        currentPerson.setPhone(updatedPerson.getPhone()); 
	        
	        // Guardar la persona actualizada en la base de datos
	        Person res = personService.save(currentPerson);
	        
	        // Devolver la respuesta con la persona actualizada
	        return new ResponseEntity<Object>(res, HttpStatus.OK);
	    } 
	    catch (Exception e) {
	        // Manejo de excepciones
	        map.put("message", e.getMessage());
	        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	    } 
	}
	
	
	@DeleteMapping("/persons/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Person currentPerson = personService.findById(id); 
			personService.delete(currentPerson);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}	
}
