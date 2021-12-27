package com.movie.demo.service;

import java.util.List;

import com.movie.demo.domain.City;
import com.movie.demo.service.dto.CityDTO;

public interface CityService {

	List<City> getAllCities();

	City getCityById(Integer cityId);

	public City saveCity(CityDTO cityDTO);
}
