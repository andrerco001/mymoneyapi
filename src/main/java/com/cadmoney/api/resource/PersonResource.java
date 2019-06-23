package com.cadmoney.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cadmoney.api.model.Person;
import com.cadmoney.api.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonResource
{
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping
	public List<Person> findAllListPersons()
	{
		return personRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person, HttpServletResponse response) 
	{
		Person personSave = personRepository.save(person);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{code}")
				.buildAndExpand(personSave.getCode()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(personSave);
	}

	@GetMapping("/{code}")
	public ResponseEntity<Optional<Person>> findByCodePerson(@PathVariable Long code) 
	{
		Optional<Person> person = personRepository.findById(code);

		return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
	}
	
}
