package com.movie.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.Cinema;
import com.movie.demo.domain.CinemaHall;
import com.movie.demo.domain.Movie;
import com.movie.demo.domain.Show;
import com.movie.demo.exception.MovieNotFoundException;
import com.movie.demo.repository.MovieRepository;
import com.movie.demo.service.MovieService;
import com.movie.demo.service.dto.MovieDTO;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service("movieService")
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies() {

		return this.movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Integer movie_id) {

		return movieRepository.findById(movie_id).orElseThrow(() -> new MovieNotFoundException(movie_id));

	}

	@Override
	public Movie updateMovie(Movie updatedMovie, Integer movie_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(Integer movie_id) {
		this.movieRepository.deleteById(movie_id);

	}

	@Override
	public List<Show> getAllShowsByMovieId(Integer movie_id) {
		Movie movie = getMovieById(movie_id);
		return new ArrayList<>(movie.getShows());
	}

	@Override
	public List<Show> getAllShowsByMovieIdAndDate(Integer movie_id, LocalDate date) {
		Movie movie = getMovieById(movie_id);
		return movie.getShows().stream().filter(show -> show.getDate().equals(date)).collect(Collectors.toList());
	}

	@Override
	public List<CinemaHall> getAllCinemaHallsByMovieIdAndDate(Integer movie_id, LocalDate date) {
		Movie movie = getMovieById(movie_id);
		List<Show> showsList = movie.getShows().stream().filter(show -> show.getDate().equals(date))
				.collect(Collectors.toList());
		return showsList.stream().map(Show::getCinemaHall).collect(Collectors.toList());

	}

	public List<Cinema> getAllCinemasByMovieIdAndDateAndCityId(Integer movie_id, LocalDate date, Integer cityId) {
		Movie movie = getMovieById(movie_id);
		List<Show> showsList = movie.getShows().stream().filter(show -> show.getDate().equals(date))
				.collect(Collectors.toList());
		List<CinemaHall> cinemaHallList = showsList.stream().map(Show::getCinemaHall).collect(Collectors.toList());
		return cinemaHallList.stream().map(CinemaHall::getCinema).collect(Collectors.toList()).stream()
				.filter(cinema -> cinema.getCity().getCityId().equals(cityId)).collect(Collectors.toList());

	}

	@Override
	public Movie addMovie(MovieDTO movieDto) {
		// TODO Auto-generated method stub
		Movie newMovie=new Movie();
		BeanUtils.copyProperties(movieDto, newMovie);
		return this.movieRepository.save(newMovie);
	}

}
