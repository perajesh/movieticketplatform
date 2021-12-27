package com.movie.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.Cinema;
import com.movie.demo.domain.CinemaHall;
import com.movie.demo.exception.AuditoriumNotFoundException;
import com.movie.demo.repository.CinemaHallRepository;
import com.movie.demo.repository.CinemaRepository;
import com.movie.demo.service.CinemaHallService;
import com.movie.demo.service.CinemaService;
import com.movie.demo.service.dto.CinemaHallDTO;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service("cinemaHallService")
@Transactional
public class CinemaHallServiceImpl implements CinemaHallService {

	@Autowired
	CinemaHallRepository cinemaHallRepository;

	@Autowired
	CinemaRepository cinemaRepository;

	@Override
	public List<CinemaHall> getAllCinemaHalls() {
		return this.cinemaHallRepository.findAll();
	}

	@Override
	public CinemaHall getCinemaHallById(Integer CinemaHall_id) {
		return this.cinemaHallRepository.findById(CinemaHall_id)
				.orElseThrow(() -> new AuditoriumNotFoundException(CinemaHall_id));
	}

	@Override
	public CinemaHall addCinemaHall(CinemaHallDTO newCinemaHallDto) throws Exception {
		CinemaHall cinemaHall = new CinemaHall();
		cinemaHall.setTotalSeats(newCinemaHallDto.getTotalSeats());
		cinemaHall.setName(newCinemaHallDto.getName());
		Cinema cinema = this.cinemaRepository.findByName(newCinemaHallDto.getCinema().getName());
		if (cinema != null) {
			cinemaHall.setCinema(cinema);
		}else {
			throw new Exception("cinema not found Exception"+newCinemaHallDto.getCinema().getName());
		}
		return this.cinemaHallRepository.save(cinemaHall);
	}

	@Override
	public CinemaHall updateCinemaHall(CinemaHall updatedCinemaHall, Integer CinemaHall_id) {
		return this.cinemaHallRepository.findById(CinemaHall_id).map(cinemaHall -> {
			cinemaHall.setCinema(updatedCinemaHall.getCinema());
			cinemaHall.setCinemaSeats(updatedCinemaHall.getCinemaSeats());
			cinemaHall.setTotalSeats(updatedCinemaHall.getTotalSeats());
			cinemaHall.setShows(updatedCinemaHall.getShows());

			return this.cinemaHallRepository.save(cinemaHall);
		}).orElseGet(() -> {
			updatedCinemaHall.setCinemaHallId(CinemaHall_id);
			return cinemaHallRepository.save(updatedCinemaHall);
		});
	}

	@Override
	public void deleteCinemaHallById(Integer CinemaHall_id) {
		this.cinemaHallRepository.deleteById(CinemaHall_id);

	}

}
