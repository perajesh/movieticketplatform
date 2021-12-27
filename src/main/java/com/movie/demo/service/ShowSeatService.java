package com.movie.demo.service;

import java.util.List;

import com.movie.demo.domain.ShowSeat;

public interface ShowSeatService {

	List<ShowSeat> getAllSeatBooked();

	ShowSeat getSeatBookedById(Integer showSeatId);

	ShowSeat addSeatBooked(ShowSeat newSeatBooked);

	ShowSeat updateSeatBooked(ShowSeat updatedSeatBooked, Integer showSeatId);

	void deleteSeatBookedById(Integer showSeatId);
}
