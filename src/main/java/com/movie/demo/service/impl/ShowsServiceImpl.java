
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
import com.movie.demo.repository.CinemaHallRepository;
import com.movie.demo.repository.MovieRepository;
import com.movie.demo.repository.ShowRepository;
import com.movie.demo.service.ShowService;
import com.movie.demo.service.dto.ShowDTO;

@Service("showService")
@Transactional
public class ShowsServiceImpl implements ShowService {

	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	CinemaHallRepository cinemaHallRepository;

	@Override
	public List<Show> getAllShows() {

		return this.showRepository.findAll();
	}

	@Override
	public Show getShowById(Integer showId) {
		return this.showRepository.findById(showId).get();
	}

	@Override
	public Show addShow(ShowDTO showDto) {
		Show show=new Show();
		show.setDate(showDto.getDate());
		show.setStartTime(showDto.getStartTime());
		show.setEndTime(showDto.getEndTime());
		show.setMovie(this.movieRepository.findById(showDto.getMovie().getMovieId()).get());
		show.setCinemaHall(this.cinemaHallRepository.findById(showDto.getCinemaHall().getCinemaHallId()).get());
		return this.showRepository.save(show);
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

	@Override
	public void deleteShowById(Integer showid) {
		// TODO Auto-generated method stub
		this.showRepository.deleteById(showid);
	}
	

}
