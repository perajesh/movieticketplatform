package com.movie.demo.service.dto;



public class CinemaHallDTO {

	private String name;

	private Integer totalSeats;
	private Integer cinemaHallId;
	
	private CinemaDTO cinema;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public CinemaDTO getCinema() {
		return cinema;
	}

	public void setCinema(CinemaDTO cinema) {
		this.cinema = cinema;
	}

	public Integer getCinemaHallId() {
		return cinemaHallId;
	}

	public void setCinemaHallId(Integer cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}
	
	
	
}
