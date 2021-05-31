package io.github.hoteltransilvania.checkins.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.hoteltransilvania.checkins.model.Checkins;
import io.github.hoteltransilvania.repository.CheckinsRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/checkins")
public class CheckinsController {
	
	@Autowired
	private CheckinsRepository repository;
	
	@PostMapping
	public Checkins save(@RequestBody Checkins guest) {
		return repository.save(guest);	
	}
	
	@GetMapping("search")
	public java.util.List<Checkins> getSearch(@RequestBody Checkins guest) {
		return repository
				.findAll();	
				//.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public java.util.List<Checkins> getAll() {
		return repository
				.findAll();	
				//.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	
	/*@GetMapping("{documento}")
	public Guests getById(@PathVariable String documento) {
		return repository
				.findById(documento)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}*/
}
