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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_cinema_hall")
public class CinemaHall implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5017243350567726050L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cinema_hall_id")
	private Integer cinemaHallId;

	@Column(name = "name")
	private String name;

	@Column(name = "totalSeats")
	private Integer totalSeats;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cinemaid", nullable = false)
	@JsonManagedReference
	private Cinema cinema;

	@OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL)
	private Set<Show> shows;

	@OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL)
	private Set<CinemaSeat> cinemaSeats;

	public CinemaHall() {

	}

	public Set<Show> getShows() {
		return shows;
	}

	public void setShows(Set<Show> shows) {
		this.shows = shows;
	}

	public Set<CinemaSeat> getCinemaSeats() {
		return cinemaSeats;
	}

	public void setCinemaSeats(Set<CinemaSeat> cinemaSeats) {
		this.cinemaSeats = cinemaSeats;
	}

	public CinemaHall(String name, Integer totalSeats, Cinema cinema) {
		super();
		this.name = name;
		this.totalSeats = totalSeats;
		this.cinema = cinema;
	}

	public Integer getCinemaHallId() {
		return cinemaHallId;
	}

	public void setCinemaHallId(Integer cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}

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

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

}
