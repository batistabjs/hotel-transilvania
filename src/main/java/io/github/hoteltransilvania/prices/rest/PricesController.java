package io.github.hoteltransilvania.prices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.hoteltransilvania.prices.model.Prices;
import io.github.hoteltransilvania.repository.PricesRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/prices")
public class PricesController {
	
	@Autowired
	private PricesRepository repository;
	
	@GetMapping("search")
	public java.util.List<Prices> getSearch(@RequestBody Prices prices) {
		return repository
				.findAll();	
				//.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public java.util.List<Prices> getAll() {
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

