package com.movie.demo.service;

import java.util.List;

import com.movie.demo.domain.Booking;

public interface BookingService {

	List<Booking> getAllBookings();

    Booking getBookingById(Integer booking_id);

    Booking addBooking(Booking newBooking);

    Booking updateBooking(Booking updatedBooking, Integer booking_id);

    void deleteBookingById(Integer booking_id);
}
