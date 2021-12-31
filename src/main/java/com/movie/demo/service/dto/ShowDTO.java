package com.movie.demo.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Convert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.movie.demo.config.LocalDateDeserializer;
import com.movie.demo.config.LocalDateTimeConverter;
import com.movie.demo.domain.CinemaHall;
import com.movie.demo.domain.Movie;

public class ShowDTO {

	private LocalDate date;

	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime endTime;
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime startTime;
	private MovieDTO movie;
	private CinemaHallDTO cinemaHall;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
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
