package com.movie.demo.service.dto;

import javax.persistence.Column;

public class CinemaDTO {

	private String name;
	private Integer totalCinemaHalls;
	
	private CityDTO city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalCinemaHalls() {
		return totalCinemaHalls;
	}

	public void setTotalCinemaHalls(Integer totalCinemaHalls) {
		this.totalCinemaHalls = totalCinemaHalls;
	}

	public CityDTO getCity() {
		return city;
	}

	public void setCity(CityDTO city) {
		this.city = city;
	}

	
}
