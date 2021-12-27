
package com.movie.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.CinemaSeat;
import com.movie.demo.domain.Show;
import com.movie.demo.repository.ShowRepository;
import com.movie.demo.service.ShowService;

@Service("showService")
@Transactional
public class ShowsServiceImpl implements ShowService {

	@Autowired
	ShowRepository showRepository;

	@Override
	public List<Show> getAllShows() {

		return this.showRepository.findAll();
	}

	@Override
	public Show getShowById(Integer showId) {
		return this.showRepository.findById(showId).get();
	}

	@Override
	public Show addShow(Show newShow) {
		return this.showRepository.save(newShow);
	}

	@Override
	public Show updateShow(Show updatedShow, Integer showId) {
		return this.showRepository.findById(showId).map(show -> {
			show.setDate(updatedShow.getDate());
			show.setStartTime(updatedShow.getStartTime());
			show.setEndTime(updatedShow.getEndTime());
			show.setMovie(updatedShow.getMovie());
			show.setCinemaHall(updatedShow.getCinemaHall());
			return this.showRepository.save(show);
		}).orElseGet(() -> {
			updatedShow.setShowId(showId);
			return showRepository.save(updatedShow);
		});
	}

	@Override
	public List<CinemaSeat> getSeatsByShowId(Integer showId) {
		Show show=getShowById(showId);
		return new ArrayList<>(show.getCinemaHall().getCinemaSeats());
	}

	@Override
	public List<Show> getAllScreenings(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return this.showRepository.findAll().stream()
				.filter(show -> show.getDate().isAfter(startDate) && show.getDate().isBefore(endDate))
				.collect(Collectors.toList());
	}

}
