package com.movie.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.Cinema;
import com.movie.demo.domain.CinemaHall;
import com.movie.demo.domain.City;
import com.movie.demo.repository.CinemaRepository;
import com.movie.demo.repository.CityRepository;
import com.movie.demo.service.CinemaService;
import com.movie.demo.service.dto.CinemaDTO;

@Service("cinemaService")
@Transactional
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	CinemaRepository cinemaRepository;
	
	@Autowired
	CityRepository cityRepository;

	@Override
	public List<Cinema> getAllTheatres() {

		return this.cinemaRepository.findAll();
	}

	@Override
	public Cinema getTheatreById(Integer cinemaId) {

		return this.cinemaRepository.findById(cinemaId).get();
	}

	@Override
	public Cinema addCinema(CinemaDTO cinemaDto) throws Exception {
		
		Cinema cinema = new Cinema();
		cinema.setName(cinemaDto.getName());
		cinema.setTotalCinemaHalls(cinemaDto.getTotalCinemaHalls());
		City city = this.cityRepository.findById(cinemaDto.getCity().getCityId()).get();
		if (city != null) {
			cinema.setCity(city);
		}else {
			throw new Exception("city not found Exception"+cinemaDto.getCity().getCityId());
		}
		return this.cinemaRepository.save(cinema);
	}

	@Override
	public Cinema updateTheatre(CinemaDTO cinemaDto, Integer cinemaId) {
		Cinema cinemaDb=this.cinemaRepository.findById(cinemaId).get();
		cinemaDb.setName(cinemaDto.getName());
		cinemaDb.setTotalCinemaHalls(cinemaDto.getTotalCinemaHalls());
		return this.cinemaRepository.save(cinemaDb);
	}

	@Override
	public void deleteCinemaById(Integer cinemaId) {
		this.cinemaRepository.deleteById(cinemaId);
	}

}
