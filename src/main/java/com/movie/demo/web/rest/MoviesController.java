package com.movie.demo.web.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.domain.Cinema;
import com.movie.demo.domain.CinemaHall;
import com.movie.demo.domain.Movie;
import com.movie.demo.domain.Show;
import com.movie.demo.exception.HousefulException;
import com.movie.demo.exception.ShowNotFoundException;
import com.movie.demo.service.MovieService;
import com.movie.demo.service.dto.MovieDTO;

@RestController
@RequestMapping("/api/movie")
public class MoviesController {

	@Autowired
	MovieService movieService;

	@GetMapping("/movies")
	public ResponseEntity<?> getAllMovies() {
		List<Movie> movies = movieService.getAllMovies();
		return ResponseEntity.status(HttpStatus.OK).body(movies);

	}

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<?> getMovieById(@PathVariable Integer movieId) {
		Movie movie = movieService.getMovieById(movieId);
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}

	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody MovieDTO movieDto) {
		Movie movie = this.movieService.addMovie(movieDto);
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}

	@DeleteMapping("/movies/{movie_id}")
	public ResponseEntity<?> deleteMovieById(@PathVariable Integer movie_id) {
		this.movieService.deleteMovie(movie_id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/movies/{movie_id}/shows")
	public ResponseEntity<?> getAllShowsByMovieId(@PathVariable Integer movie_id) {
		List<Show> shows = this.movieService.getAllShowsByMovieId(movie_id);
		return ResponseEntity.status(HttpStatus.OK).body(shows);
	}

	@GetMapping("/movies/{movie_id}/showsbydate")
	public ResponseEntity<?> getAllShowsByMovieIdAndDate(@RequestParam(required = true) Map<String, String> date,
			@PathVariable Integer movie_id) throws ShowNotFoundException{
		List<Show> shows = null;
		
		if(!date.isEmpty()) {
			 LocalDate newdate = LocalDate.parse(date.get("date"));
			 shows=this.movieService.getAllShowsByMovieIdAndDate(movie_id, newdate);
		}
		
		if(shows==null) {
			throw new ShowNotFoundException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(shows);
	}
	
	@GetMapping("/movies/{movie_id}/cinemaHalls")
	public ResponseEntity<?> getAllCinemaHallsByMovieIdAndDate(@RequestParam(required = true) Map<String, String> date,
			@PathVariable Integer movie_id) throws Exception {
		List<CinemaHall> cinemahalls = null;
		LocalDate newdate =null;
		if(!date.isEmpty()) {
			newdate = LocalDate.parse(date.get("date"));
			 cinemahalls=this.movieService.getAllCinemaHallsByMovieIdAndDate(movie_id, newdate);
		}
		
		if(cinemahalls==null) {
			throw new Exception("CinemaHalls not found for the"+ movie_id+" "+ newdate);
		}
		return ResponseEntity.status(HttpStatus.OK).body(cinemahalls);
	}
	
	
	@GetMapping("/movies/{movie_id}/cinemas/{cityId}")
	public ResponseEntity<?> getAllCinemasByMovieIdAndDateAndCityId(@RequestParam(required = true) Map<String, String> date,
			@PathVariable Integer movie_id,@PathVariable Integer cityid) throws Exception {
		List<Cinema> cinemas = null;
		 LocalDate newdate=null;
		if(!date.isEmpty()) {
			newdate = LocalDate.parse(date.get("date"));
			 cinemas=this.movieService.getAllCinemasByMovieIdAndDateAndCityId(movie_id, newdate,cityid);
		}
		
		if(cinemas==null) {
			 throw new Exception("Cinemas not found in the"+ cityid+" for the"+ movie_id+"  and date"+ newdate);
		}
		return ResponseEntity.status(HttpStatus.OK).body(cinemas);
	}


}
