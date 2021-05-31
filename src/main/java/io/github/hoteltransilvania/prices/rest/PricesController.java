package io.github.hoteltransilvania.prices.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.hoteltransilvania.guests.model.Guests;
import io.github.hoteltransilvania.prices.model.Prices;
import io.github.hoteltransilvania.repository.PricesRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/prices")
public class PricesController {
	
	@Autowired
	private PricesRepository repository;
	
	@GetMapping
	public List<Prices> getAll() {
		return repository.findAll();
	}

}

