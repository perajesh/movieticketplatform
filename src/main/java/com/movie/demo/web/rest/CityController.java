package com.movie.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.domain.City;
import com.movie.demo.service.CityService;
import com.movie.demo.service.dto.CityDTO;


@RestController
@RequestMapping("/api/city")
public class CityController {

	@Autowired
	CityService cityService;
	
	@GetMapping("/allcityies")
	public ResponseEntity<List<City>> getAllCities() {
		return ResponseEntity.ok(this.cityService.getAllCities());
	}
	
	@PostMapping("/addState")
	public ResponseEntity<?> addCity(@RequestBody CityDTO cityDTO)  {
		City  city=this.cityService.saveCity(cityDTO);
		return ResponseEntity.status(HttpStatus.OK).body(city);
	}
	
}
