package br.edu.univas.gabriel.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.gabriel.dto.HotelDto;
import br.edu.univas.gabriel.service.HotelService;

@RestController
@RequestMapping("/api")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@PostMapping("/entidades")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid HotelDto dto) throws ParseException {
		service.create(dto);
	}
	
	@PutMapping("/entidades/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody @Valid HotelDto dto, @PathVariable Long id) {
		service.update(id, dto);
	}
	
	@DeleteMapping("/entidades/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/entidades")
	public List<HotelDto> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/entidades/{id}")
	public HotelDto getById(@PathVariable Long id) {
		return service.getById(id);
	}
}