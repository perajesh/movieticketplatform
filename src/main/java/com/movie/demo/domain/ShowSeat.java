package com.movie.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_show_seat")
public class ShowSeat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6683392315641723181L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="showSeatId")
	private Integer showSeatId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="price")
	private Double price;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cinemaSeatid", nullable = false)
	private CinemaSeat cinemaSeat;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "showId", nullable = false)
	private Show show;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bookingId", nullable = false)
	private Booking booking;
	
	public ShowSeat() {
		
	}

	public Integer getShowSeatId() {
		return showSeatId;
	}

	public void setShowSeatId(Integer showSeatId) {
		this.showSeatId = showSeatId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CinemaSeat getCinemaSeat() {
		return cinemaSeat;
	}

	public void setCinemaSeat(CinemaSeat cinemaSeat) {
		this.cinemaSeat = cinemaSeat;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	
}
