package com.movie.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.ShowSeat;
import com.movie.demo.repository.ShowSeatRepository;
import com.movie.demo.service.ShowSeatService;

@Service("showSeatService")
@Transactional
public class ShowSeatServiceImpl implements ShowSeatService{

	@Autowired
	ShowSeatRepository showSeatRepository;
	
	@Override
	public List<ShowSeat> getAllSeatBooked() {
	
		return this.showSeatRepository.findAll();
	}

	@Override
	public ShowSeat getSeatBookedById(Integer showSeatId) {
		
		return this.showSeatRepository.findById(showSeatId).get();
	}

	@Override
	public ShowSeat addSeatBooked(ShowSeat newSeatBooked) {
		
		return this.showSeatRepository.save(newSeatBooked);
	}

	@Override
	public ShowSeat updateSeatBooked(ShowSeat updatedSeatBooked, Integer showSeatId) {
		return this.showSeatRepository.findById(showSeatId).map(showSeat -> {
			showSeat.setPrice(updatedSeatBooked.getPrice());
			showSeat.setCinemaSeat(updatedSeatBooked.getCinemaSeat());
			showSeat.setShow(updatedSeatBooked.getShow());
			showSeat.setStatus(updatedSeatBooked.getStatus());
			return this.showSeatRepository.save(showSeat);
		}).orElseGet(() -> {
			updatedSeatBooked.setShowSeatId(showSeatId);
			return this.showSeatRepository.save(updatedSeatBooked);
		});
	}

	@Override
	public void deleteSeatBookedById(Integer showSeatId) {
		this.showSeatRepository.deleteById(showSeatId);
		
	}

}
