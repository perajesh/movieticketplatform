package com.movie.demo.service;

import java.util.List;

import com.movie.demo.domain.CinemaHall;
import com.movie.demo.service.dto.CinemaHallDTO;

public interface CinemaHallService {

	List<CinemaHall> getAllCinemaHalls();

	CinemaHall getCinemaHallById(Integer CinemaHall_id);

	CinemaHall addCinemaHall(CinemaHallDTO cinemaHallDTO) throws Exception;

	CinemaHall updateCinemaHall(CinemaHall updatedCinemaHall, Integer CinemaHall_id);

	void deleteCinemaHallById(Integer CinemaHall_id);
}
