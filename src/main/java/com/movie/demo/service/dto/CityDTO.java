package com.movie.demo.service.dto;

import com.movie.demo.domain.State;

public class CityDTO {

	private Integer cityId;
	private String cityName;
	private String zipcode;
	private StateDTO state;
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public StateDTO getState() {
		return state;
	}
	public void setState(StateDTO state) {
		this.state = state;
	}
	
	

}
