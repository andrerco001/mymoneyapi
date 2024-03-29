package com.cadmoney.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cadmoney.api.event.ResourceCreatedEvent;
import com.cadmoney.api.model.Category;
import com.cadmoney.api.repository.CategoriesRepository;

@RestController
@RequestMapping("/categories")
public class CategoryResource 
{
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	// Create
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category, HttpServletResponse response) 
	{
		Category categorySave = categoriesRepository.save(category);
		
		publisher.publishEvent(new ResourceCreatedEvent(this, response,categorySave.getCode()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categorySave);
	}
	
	// Read
	@GetMapping
	public List<Category> findAllListCategories()
	{
		return categoriesRepository.findAll();
	}

	@GetMapping("/{code}")
	public ResponseEntity<Category> findByCodeCategory(@PathVariable Long code) 
	{
		Category category = categoriesRepository.findOne(code);

		return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
	}
	
	// Update
	
	// Delete

}
