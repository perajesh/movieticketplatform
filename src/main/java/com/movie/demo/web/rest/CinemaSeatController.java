package com.movie.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.domain.Cinema;
import com.movie.demo.domain.CinemaHall;
import com.movie.demo.domain.CinemaSeat;
import com.movie.demo.service.CinemaSeatService;
import com.movie.demo.service.dto.CinemaHallDTO;
import com.movie.demo.service.dto.CinemaSeatDTO;

@RestController
@RequestMapping("/api/cinemaSeat")
public class CinemaSeatController {

	@Autowired
	CinemaSeatService cinemaSeatService;

	@GetMapping("/cinemaseats")
	public ResponseEntity<List<CinemaSeat>> getAllSeats() {
		return ResponseEntity.ok(this.cinemaSeatService.getAllSeats());
	}

	@DeleteMapping("/cinemaSeat/{cinemaSeatId}")
	public ResponseEntity<?> deleteMovieById(@PathVariable Integer cinemaSeatId) {
		this.cinemaSeatService.deleteSeatById(cinemaSeatId);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/addSeat")
	public ResponseEntity<?> addCinemaSeat(@RequestBody CinemaSeatDTO cinemaSeatDTO) throws Exception {
		CinemaSeat  cinemaSeat=this.cinemaSeatService.addSeat(cinemaSeatDTO);
		return ResponseEntity.status(HttpStatus.OK).body(cinemaSeat);
	}
	
	@PutMapping("/updateSeat/{cinemaseatid}")
	public ResponseEntity<?> updateCinemaSeat(@RequestBody CinemaSeatDTO cinemaSeatDTO,@PathVariable Integer cinemaseatid) throws Exception {
		CinemaSeat  cinemaSeat=this.cinemaSeatService.updateSeat(cinemaSeatDTO,cinemaseatid);
		return ResponseEntity.status(HttpStatus.OK).body(cinemaSeat);
	}
	
}
