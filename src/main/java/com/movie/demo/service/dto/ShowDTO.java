package com.movie.demo.service.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.movie.demo.config.LocalDateDeserializer;
import com.movie.demo.domain.CinemaHall;
import com.movie.demo.domain.Movie;

public class ShowDTO {

	private LocalDate date;

	
	private LocalDate endTime;
	
	private LocalDate startTime;
	private MovieDTO movie;
	private CinemaHallDTO cinemaHall;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}

	public CinemaHallDTO getCinemaHall() {
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHallDTO cinemaHall) {
		this.cinemaHall = cinemaHall;
	}

}
