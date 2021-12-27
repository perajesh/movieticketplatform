package com.movie.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.City;
import com.movie.demo.repository.CityRepository;
import com.movie.demo.repository.StateRepository;
import com.movie.demo.service.CityService;
import com.movie.demo.service.dto.CityDTO;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{

	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	StateRepository  stateRepository;
	
	@Override
	public City saveCity(CityDTO cityDto) {
		City city=new City();
		city.setCityName(cityDto.getCityName());
		city.setZipcode(cityDto.getZipcode());
		city.setState(this.stateRepository.findById(cityDto.getState().getStateId()).get());
		return this.cityRepository.save(city);
	}

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		return this.cityRepository.findAll();
	}

	@Override
	public City getCityById(Integer cityId) {
		// TODO Auto-generated method stub
		return this.cityRepository.findById(cityId).get();
	}

}
