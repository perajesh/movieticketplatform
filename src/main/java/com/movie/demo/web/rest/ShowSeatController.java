package com.movie.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.domain.Show;
import com.movie.demo.domain.ShowSeat;
import com.movie.demo.service.ShowSeatService;

@RestController
@RequestMapping("/api/showseat")
public class ShowSeatController {

	@Autowired
	ShowSeatService showSeatService;
	
	@GetMapping("/showbookedseats")
	public ResponseEntity<List<ShowSeat>> getAllSeatBooked() {
		return ResponseEntity.ok(this.showSeatService.getAllSeatBooked());
	}
}
