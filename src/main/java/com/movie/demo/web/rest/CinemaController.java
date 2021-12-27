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

import com.movie.demo.domain.Cinema;
import com.movie.demo.domain.CinemaHall;
import com.movie.demo.domain.User;
import com.movie.demo.service.CinemaService;
import com.movie.demo.service.dto.CinemaDTO;
import com.movie.demo.service.dto.CinemaHallDTO;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {

	@Autowired
	CinemaService cinemaService;

	@GetMapping("/cinemas")
	public ResponseEntity<List<Cinema>> getAllCinemas() {
		return ResponseEntity.ok(this.cinemaService.getAllTheatres());
	}
	
	@PostMapping("/addcinema")
	public ResponseEntity<?> addCinema(@RequestBody CinemaDTO cinemaDTO) throws Exception {
		Cinema  cinema=this.cinemaService.addCinema(cinemaDTO);
		return ResponseEntity.status(HttpStatus.OK).body(cinema);
	}
}

