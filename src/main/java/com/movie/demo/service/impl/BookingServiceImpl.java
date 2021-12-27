package com.movie.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.Booking;
import com.movie.demo.repository.BookingRepository;
import com.movie.demo.service.BookingService;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return this.bookingRepository.findAll();
	}

	@Override
	public Booking getBookingById(Integer booking_id) {
		// TODO Auto-generated method stub
		return this.bookingRepository.findById(booking_id).get();
	}

	@Override
	public Booking addBooking(Booking newBooking) {
		// TODO Auto-generated method stub
		return this.bookingRepository.save(newBooking);
	}

	@Override
	public Booking updateBooking(Booking updatedBooking, Integer booking_id) {
		Booking bookingDB=  bookingRepository.findById(booking_id).get();
		bookingDB.setStatus(updatedBooking.getStatus());
		return this.bookingRepository.save(bookingDB);
	}

	@Override
	public void deleteBookingById(Integer booking_id) {
		this.bookingRepository.deleteById(booking_id);

	}

}
