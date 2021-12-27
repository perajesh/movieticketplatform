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
@Table(name = "tbl_cinema")
public class Cinema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -623765354258674292L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cinemaId")
	private Integer cinemaId;

	@Column(name = "Name")
	private String name;

	@Column(name = "totalCinemaHalls")
	private Integer totalCinemaHalls;

	@ManyToOne( optional = false)
	@JoinColumn(name = "cityid", nullable = false)
	@JsonManagedReference
	private City city;

	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<CinemaHall> cinemaHalls;

	public Cinema() {

	}

	public Cinema(Integer cinemaId, String name, Integer totalCinemaHalls, City city) {
		super();
		this.cinemaId = cinemaId;
		this.name = name;
		this.totalCinemaHalls = totalCinemaHalls;
		this.city = city;
	}

	public Integer getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<CinemaHall> getCinemaHalls() {
		return cinemaHalls;
	}

	public void setCinemaHalls(Set<CinemaHall> cinemaHalls) {
		this.cinemaHalls = cinemaHalls;
	}

	
	
}
