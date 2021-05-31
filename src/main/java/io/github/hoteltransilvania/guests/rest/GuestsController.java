package io.github.hoteltransilvania.guests.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.hoteltransilvania.guests.model.Guests;
import io.github.hoteltransilvania.repository.GuestsRepository;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/guests")
public class GuestsController {
	
	@Autowired
	private GuestsRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Guests save(@RequestBody Guests guest) {
		return repository.save(guest);	
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		//return repository.deleteById(id);
	}

	@GetMapping
	public List<Guests> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("search")
	public List<Guests> getSearch(@RequestBody Guests guest) {
		if (guest.getNome() != null) {
			return repository.findGuestsByNameLike(guest.getNome());
		} 
		else if (guest.getDocumento() != null) {
			return repository.findGuestsByDocLike(guest.getDocumento());
		}
		else {
			return repository.findGuestsByTelLike(guest.getTelefone());
		}
	}
}
