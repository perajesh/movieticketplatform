package com.movie.demo.service;

import java.util.List;

import com.movie.demo.domain.Cinema;
import com.movie.demo.service.dto.CinemaDTO;

public interface CinemaService {
	
	List<Cinema> getAllTheatres();

	Cinema getTheatreById(Integer cinemaId);

	Cinema addCinema(CinemaDTO cinemaDTO) throws Exception;

	Cinema updateTheatre(CinemaDTO cinemaDTO, Integer cinemaId);

	void deleteCinemaById(Integer cinemaId);
}
