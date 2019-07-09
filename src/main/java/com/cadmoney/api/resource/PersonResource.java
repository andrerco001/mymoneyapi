package com.cadmoney.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cadmoney.api.event.ResourceCreatedEvent;
import com.cadmoney.api.model.Person;
import com.cadmoney.api.repository.PersonRepository;
import com.cadmoney.api.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonResource
{
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonService personService;

	@Autowired
	private ApplicationEventPublisher publisher;

	// Create
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person, HttpServletResponse response) 
	{
		Person personSave = personRepository.save(person);

		publisher.publishEvent(new ResourceCreatedEvent(this, response, personSave.getCode()));

		return ResponseEntity.status(HttpStatus.CREATED).body(personSave);
	}

	// Read
	@GetMapping
	public List<Person> findAllListPersons()
	{
		return personRepository.findAll();
	}

	@GetMapping("/{code}")
	public ResponseEntity<Person> findByCodePerson(@PathVariable Long code) 
	{
		Person person = personRepository.findOne(code);

		return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
	}
	
	// Update
	@PutMapping("/{code}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long code, @Valid @RequestBody Person person) 
	{
		Person personSave = personService.updatePerson(code, person);

		return ResponseEntity.ok(personSave);
	}

	@PutMapping("/{code}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePropertiesActive(@PathVariable Long code, @RequestBody Boolean active) 
	{
		personService.updatePropertiesActive(code, active);
	}

	// Delete
	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable Long code) 
	{
		personRepository.delete(code);
	}

}


