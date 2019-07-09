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
import org.springframework.web.bind.annotation.RestController;

import com.cadmoney.api.event.ResourceCreatedEvent;
import com.cadmoney.api.model.Release;
import com.cadmoney.api.repository.ReleasesRepository;

@RestController
@RequestMapping("/releases")
public class ReleasesResource 
{
	@Autowired
	private ReleasesRepository releasesRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	// Create
	@PostMapping
	public ResponseEntity<Release> createRelease(@Valid @RequestBody Release release, HttpServletResponse response)
	{
		Release releaseSave = releasesRepository.save(release);
		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, releaseSave.getCode()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(releaseSave);
	}
	
	// Read
	@GetMapping
	public List<Release> findAllListReleases()
	{
		return releasesRepository.findAll();
	}

	@GetMapping("/{code}")
	public ResponseEntity<Release> findReleasesByCode(@PathVariable Long code)
	{
		Release release = releasesRepository.findOne(code);

		return release != null ? ResponseEntity.ok(release) : ResponseEntity.notFound().build();
	}
	
	// Update
	
	
	// Delete
	
	

}
