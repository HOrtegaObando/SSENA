package com.ke_detalles.SSENA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ke_detalles.SSENA.dao.PersonDao;
import com.ke_detalles.SSENA.entity.Person;


import jakarta.transaction.Transactional;

@Service

public class personserviceimplement implements personservice{
	
	@Autowired
	private PersonDao persondao;

	@Override
	@Transactional
	public List<Person> findAll() {
		return(List<Person>)persondao.findAll();
	
	}

	@Override
	@Transactional
	public Person save(Person person) {
		
		return persondao.save(person);
	}

	@Override
	@Transactional
	public Person findById(Long id) {
		
		return persondao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Person person) {
		persondao.delete(person);
		
		
	}

}