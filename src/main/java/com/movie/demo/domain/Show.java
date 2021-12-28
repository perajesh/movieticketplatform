package com.movie.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.Temporal;import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_show")
public class Show implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -113418772895704612L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="showId")
	private Integer showId;

	
	@Column(name="date")
	private LocalDate date;

	@Column(name="starttime")
	private LocalDate startTime;

	@Column(name="endtime")
	private LocalDate endTime;

	@ManyToOne(optional = false)
	@JoinColumn(name = "movie_id",nullable = false)
	@JsonManagedReference
	private Movie movie;

	@ManyToOne( optional = false)
	@JoinColumn(name = "cinemaHallid",nullable = false)
	@JsonManagedReference
	private CinemaHall cinemaHall;
	
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	private Set<ShowSeat> bookedSeats;
	
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private Set<Booking> bookings;
	
	public Show() {
		
	}

	public Show(Integer showId, LocalDate date, LocalDate startTime, LocalDate endTime, Movie movie,
			CinemaHall cinemaHall) {
		super();
		this.showId = showId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movie = movie;
		this.cinemaHall = cinemaHall;
	}

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public CinemaHall getCinemaHall() {
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHall cinemaHall) {
		this.cinemaHall = cinemaHall;
	}

	public Set<ShowSeat> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Set<ShowSeat> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	
	

}
