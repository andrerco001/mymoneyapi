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

import com.cadmoney.api.model.Category;
import com.cadmoney.api.repository.CategoriesRepository;

@RestController
@RequestMapping("/categories")
public class CategoryResource 
{
	@Autowired
	private CategoriesRepository categoriesRepository;

	@GetMapping
	public List<Category> findAllListCategories()
	{
		return categoriesRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category, HttpServletResponse response) 
	{
		Category categorySave = categoriesRepository.save(category);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{code}")
				.buildAndExpand(categorySave.getCode()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(categorySave);
	}

	@GetMapping("/{code}")
	public ResponseEntity<Optional<Category>> findByCodeCategory(@PathVariable Long code) 
	{
		Optional<Category> category = categoriesRepository.findById(code);

		return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
	}

}
