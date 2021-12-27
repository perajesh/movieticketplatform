package com.movie.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.movie.demo.domain.Cinema;
import com.movie.demo.domain.CinemaHall;
import com.movie.demo.domain.Movie;
import com.movie.demo.domain.Show;
import com.movie.demo.service.dto.MovieDTO;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie getMovieById(Integer movie_id);

	Movie updateMovie(Movie updatedMovie, Integer movie_id);
	
	Movie addMovie(MovieDTO movieDto);


	void deleteMovie(Integer movie_id);

	List<Show> getAllShowsByMovieId(Integer movie_id);

	List<Show> getAllShowsByMovieIdAndDate(Integer movie_id, LocalDate localDate);
	
	List<CinemaHall> getAllCinemaHallsByMovieIdAndDate(Integer movie_id, LocalDate date);
	List<Cinema> getAllCinemasByMovieIdAndDateAndCityId(Integer movie_id, LocalDate date,Integer cityId);
}
