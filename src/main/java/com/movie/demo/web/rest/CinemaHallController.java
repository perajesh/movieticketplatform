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
import com.movie.demo.domain.Movie;
import com.movie.demo.service.CinemaHallService;
import com.movie.demo.service.dto.CinemaHallDTO;
import com.movie.demo.service.dto.MovieDTO;

@RestController
@RequestMapping("/api/cinemahall")
public class CinemaHallController {

	@Autowired
	CinemaHallService cinemaHallService;
	
	@GetMapping("/cinemahalls")
	public ResponseEntity<List<CinemaHall>> getAllCinemas() {
		return ResponseEntity.ok(this.cinemaHallService.getAllCinemaHalls());
	}
	
	@PostMapping("/addcinemahall")
	public ResponseEntity<?> addCinemaHall(@RequestBody CinemaHallDTO cinemaHallDTO) throws Exception {
		CinemaHall  cinemaHall=this.cinemaHallService.addCinemaHall(cinemaHallDTO);
		return ResponseEntity.status(HttpStatus.OK).body(cinemaHall);
	}
}
