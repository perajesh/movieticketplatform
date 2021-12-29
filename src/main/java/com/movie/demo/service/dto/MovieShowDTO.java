package com.movie.demo.service.dto;

public class MovieShowDTO {

	private String movieName;
	private Integer theaterId;
	private String theaterName;
	private Integer cityId;
	private String showDate;
	private String  screeningTime;
	private Integer numofseats;
	private String cinemaHallId;
	private String cinemaHallName;
	
	private String name;
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getScreeningTime() {
		return screeningTime;
	}
	public void setScreeningTime(String screeningTime) {
		this.screeningTime = screeningTime;
	}
	public Integer getNumofseats() {
		return numofseats;
	}
	public void setNumofseats(Integer numofseats) {
		this.numofseats = numofseats;
	}
	public String getCinemaHallId() {
		return cinemaHallId;
	}
	public void setCinemaHallId(String cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}
	public String getCinemaHallName() {
		return cinemaHallName;
	}
	public void setCinemaHallName(String cinemaHallName) {
		this.cinemaHallName = cinemaHallName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
