package com.movie.demo.service;

import java.util.List;

import com.movie.demo.domain.CinemaSeat;
import com.movie.demo.service.dto.CinemaSeatDTO;

public interface CinemaSeatService {

	List<CinemaSeat> getAllSeats();

	CinemaSeat getSeatById(Integer cinemaSeatId);

	CinemaSeat addSeat(CinemaSeatDTO cinemaSeatDTO);

	CinemaSeat updateSeat(CinemaSeat updatedSeat, Integer cinemaSeatId);

	void deleteSeatById(Integer cinemaSeatId);
}
