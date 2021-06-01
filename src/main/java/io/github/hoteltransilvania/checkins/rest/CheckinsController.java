package io.github.hoteltransilvania.checkins.rest;

import java.util.List;

import javax.validation.Valid;

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

import io.github.hoteltransilvania.checkins.model.Checkins;
import io.github.hoteltransilvania.prices.model.Prices;
import io.github.hoteltransilvania.repository.CheckinsRepository;

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

@CrossOrigin
@RestController
@RequestMapping("/api/checkins")
public class CheckinsController {
	
	@Autowired
	private CheckinsRepository repository;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Checkins save(@Valid @RequestBody Checkins checkins) {			
		checkins.setId(repository.findLastId());//não criei autoincrement no bd, daí fiz essafunção
		
		return repository.save(checkins);	
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		//return repository.deleteById(id);
	}
	
	@GetMapping("searchall")
	public List<Checkins> getAll() {
		//aqui tratar calculos de diárias obtidos da Query do cálculo das diárias
		//será uma só rota para os 3 possibilidades (listar todos, presentes, antigos).
		
		return repository.findAll();
	}
	
	@GetMapping("searchold")
	public List<Checkins> getSearchOld() {
		return repository.findOldCheckins();
	}
	
	@GetMapping("searchcurrent")
	public List<Checkins> getSearchCurrent() {
		return repository.findCurrentCheckins();
	}
	
}
