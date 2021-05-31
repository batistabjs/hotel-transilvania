package io.github.hoteltransilvania.checkins.rest;

import java.time.LocalDateTime;
import java.util.List;

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
import io.github.hoteltransilvania.guests.model.Guests;
import io.github.hoteltransilvania.repository.CheckinsRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/checkins")
public class CheckinsController {
	
	@Autowired
	private CheckinsRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Checkins save(@RequestBody Checkins checkins) {
		//Checkins checkins = new Checkins();
		checkins.setId(repository.findLastId());//não criei autoincrement no bd, daí fiz essafunção
		//checkins.setHospede("12345678");
		//checkins.setDataentrada(LocalDateTime.now());
		//checkins.setDatasaida(LocalDateTime.now());
		//checkins.setAdicionalveiculo(true);
		
		System.out.println("save obj checkin");
		return repository.save(checkins);	
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		//return repository.deleteById(id);
	}
	
	@GetMapping
	public List<Checkins> getAll() {
		return repository.findAll();
	}
	
	@GetMapping("search")
	public List<Checkins> getSearch(@RequestBody Checkins checkins) {
		
		//aqui vai a logica pra calcular as datas
		
		if (checkins.getHospede() != null) {
			return repository.findCurrentCheckins();
		} 
		else{// if (checkins.getId() != null) {
			return repository.findOldCheckins();
		}
	}
}
