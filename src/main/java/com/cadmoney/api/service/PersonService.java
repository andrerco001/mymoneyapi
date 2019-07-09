package com.cadmoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadmoney.api.model.Person;
import com.cadmoney.api.repository.PersonRepository;

@Service
public class PersonService 
{
	@Autowired
	private PersonRepository personRepository;

	public Person updatePerson(Long code, Person person) 
	{
		Person personSave = searchPersonByCode(code);
		
		BeanUtils.copyProperties(person, personSave, "code");
		return personRepository.save(personSave);
	}

	public void updatePropertiesActive(Long code, Boolean active) 
	{
		Person personSave = searchPersonByCode(code);
		personSave.setActive(active);
		personRepository.save(personSave);
	}
	
	private Person searchPersonByCode(Long code) 
	{
		Person personSave = personRepository.findOne(code);
		
		if (personSave == null) 
		{
			throw new EmptyResultDataAccessException(1);
		}
		return personSave;
	}
}
