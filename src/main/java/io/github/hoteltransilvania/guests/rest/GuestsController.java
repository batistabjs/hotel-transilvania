package io.github.hoteltransilvania.guests.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.hoteltransilvania.guests.model.Guests;
import io.github.hoteltransilvania.repository.GuestsRepository;

@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@RestController
@RequestMapping("/api/guests")
public class GuestsController {
	
	@Autowired
	private GuestsRepository repository;
	
	@PostMapping
	public Guests save(@RequestBody Guests guest) {
		return repository.save(guest);	
	}
	
	@GetMapping("search")
	public java.util.List<Guests> getSearch(@RequestBody Guests guest) {
		return repository
				.findAll();	
				//.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public java.util.List<Guests> getAll() {
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
