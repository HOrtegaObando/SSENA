package com.ke_detalles.SSENA.services;

import java.util.List;

import com.ke_detalles.SSENA.entity.Person;

public interface personservice {
	
	
	
	public List<Person> findAll();
	
	public Person save(Person person);
	
	public Person findById(Long id);
	
	public void delete(Person person);

}