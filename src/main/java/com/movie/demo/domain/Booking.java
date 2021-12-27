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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_booking")
public class Booking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2079546106430273826L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingId")
	private Integer bookingId;

	@Column(name = "numberOfSeats")
	private Integer numberOfSeats;

	@Column(name = "bookingDate")
	private LocalDate bookingDate;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "showId", nullable = false)
	private Show show;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@OneToOne(mappedBy = "booking")
	private Payment payment;

	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	private Set<ShowSeat> bookedSeats;

	public Booking() {

	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<ShowSeat> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Set<ShowSeat> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	
}
