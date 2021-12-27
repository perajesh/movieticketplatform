package com.movie.demo.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_city")
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -776869745622679326L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cityId")
	private Integer cityId;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "zipcode")
	private String zipcode;

	@ManyToOne(optional = false)
	@JoinColumn(name = "state_id", nullable = false)
	@JsonManagedReference
	private State state;

	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Cinema> cinemas;

	public City() {

	}

	public City(Integer cityId, String cityName, String zipcode, State state) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.zipcode = zipcode;
		this.state = state;
	}

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Set<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(Set<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

}
