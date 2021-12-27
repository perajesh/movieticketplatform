package com.movie.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.movie.demo.domain.CinemaSeat;
import com.movie.demo.domain.Show;

public interface ShowService {

	List<Show> getAllShows();

	Show getShowById(Integer showId);

	Show addShow(Show newShow);

	Show updateShow(Show updatedShow, Integer showId);

    List<CinemaSeat> getSeatsByShowId(Integer showId);

    List<Show> getAllScreenings(LocalDate startDate, LocalDate endDate);
}
