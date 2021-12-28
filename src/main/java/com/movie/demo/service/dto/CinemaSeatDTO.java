package com.movie.demo.service.dto;

import com.movie.demo.domain.CinemaHall;

public class CinemaSeatDTO {

	private Integer cinemaSeatId;
	private Integer seatnumber;
	private String type;
	private CinemaHallDTO cinemaHall;
	public Integer getCinemaSeatId() {
		return cinemaSeatId;
	}
	public void setCinemaSeatId(Integer cinemaSeatId) {
		this.cinemaSeatId = cinemaSeatId;
	}
	public Integer getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(Integer seatnumber) {
		this.seatnumber = seatnumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public CinemaHallDTO getCinemaHall() {
		return cinemaHall;
	}
	public void setCinemaHall(CinemaHallDTO cinemaHall) {
		this.cinemaHall = cinemaHall;
	}
	
	
}
