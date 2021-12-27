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

@Entity
@Table(name = "tbl_cinema_seat")
public class CinemaSeat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1503794497977883L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cinemaSeatId")
	private Integer cinemaSeatId;

	@Column(name = "seatnumber")
	private Integer seatnumber;

	@Column(name = "type")
	private String type;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cinemahallid", nullable = false)
	private CinemaHall cinemaHall;

	@OneToMany(mappedBy = "cinemaSeat", cascade = CascadeType.ALL)
	private Set<ShowSeat> bookedSeats;

	public CinemaSeat() {

	}

	public CinemaSeat(Integer cinemaSeatId, Integer seatnumber, String type, CinemaHall cinemaHall) {
		super();
		this.cinemaSeatId = cinemaSeatId;
		this.seatnumber = seatnumber;
		this.type = type;
		this.cinemaHall = cinemaHall;
	}

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

	
}
