package com.movie.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_payment")
public class Payment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4987846584833503889L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="paymentId")
	private Integer paymentId;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="date")
	private  LocalDate date;
	
	@Column(name="discountCouponId")
	private Integer discountCouponId;
	
	@Column(name="remoteTransactionId")
	private Integer remoteTransactionId;
	
	@Column(name="paymentmethod")
	private String paymentMethod;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "bookingId", nullable = false)
	private Booking booking;
	
	public Payment() {
		
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getDiscountCouponId() {
		return discountCouponId;
	}

	public void setDiscountCouponId(Integer discountCouponId) {
		this.discountCouponId = discountCouponId;
	}

	public Integer getRemoteTransactionId() {
		return remoteTransactionId;
	}

	public void setRemoteTransactionId(Integer remoteTransactionId) {
		this.remoteTransactionId = remoteTransactionId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	
	
}
