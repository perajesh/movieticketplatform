package com.movie.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.domain.Booking;
import com.movie.demo.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/bookings")
	public ResponseEntity<?> getAllBookings(){
		List<Booking> bookings=this.bookingService.getAllBookings();
		return ResponseEntity.status(HttpStatus.OK).body(bookings);
	}
	
	

}
