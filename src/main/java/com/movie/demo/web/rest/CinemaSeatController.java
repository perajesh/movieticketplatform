package com.movie.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.domain.Cinema;
import com.movie.demo.domain.CinemaSeat;
import com.movie.demo.service.CinemaSeatService;

@RestController
@RequestMapping("/api/cinemaSeat")
public class CinemaSeatController {

	@Autowired
	CinemaSeatService cinemaSeatService;

	@GetMapping("/cinemaseats")
	public ResponseEntity<List<CinemaSeat>> getAllSeats() {
		return ResponseEntity.ok(this.cinemaSeatService.getAllSeats());
	}
}
