package com.movie.demo.service;

import java.util.List;

import com.movie.demo.domain.CinemaSeat;

public interface CinemaSeatService {

	List<CinemaSeat> getAllSeats();

	CinemaSeat getSeatById(Integer cinemaSeatId);

	CinemaSeat addSeat(CinemaSeat newSeat);

	CinemaSeat updateSeat(CinemaSeat updatedSeat, Integer cinemaSeatId);

	void deleteSeatById(Integer cinemaSeatId);
}
