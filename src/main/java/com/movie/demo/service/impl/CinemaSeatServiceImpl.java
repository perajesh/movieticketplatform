package com.movie.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.CinemaSeat;
import com.movie.demo.repository.CinemaSeatRepository;
import com.movie.demo.service.CinemaSeatService;

@Service("cinemaSeatService")
@Transactional
public class CinemaSeatServiceImpl implements CinemaSeatService{

	@Autowired
	CinemaSeatRepository cinemaSeatRepository;
	
	@Override
	public List<CinemaSeat> getAllSeats() {
		// TODO Auto-generated method stub
		return this.cinemaSeatRepository.findAll();
	}

	@Override
	public CinemaSeat getSeatById(Integer cinemaSeatId) {
		// TODO Auto-generated method stub
		return this.cinemaSeatRepository.findById(cinemaSeatId).get();
	}

	@Override
	public CinemaSeat addSeat(CinemaSeat newSeat) {
		// TODO Auto-generated method stub
		return this.cinemaSeatRepository.save(newSeat);
	}

	@Override
	public CinemaSeat updateSeat(CinemaSeat updatedSeat, Integer cinemaSeatId) {
		return this.cinemaSeatRepository.findById(cinemaSeatId).map(cinemaSeat -> {
			cinemaSeat.setSeatnumber(updatedSeat.getCinemaSeatId());
			cinemaSeat.setType(updatedSeat.getType());
			cinemaSeat.setCinemaHall(updatedSeat.getCinemaHall());
			return this.cinemaSeatRepository.save(cinemaSeat);
		}).orElseGet(() -> {
			updatedSeat.getCinemaSeatId();
			return cinemaSeatRepository.save(updatedSeat);
		});
	}

	@Override
	public void deleteSeatById(Integer cinemaSeatId) {
		// TODO Auto-generated method stub
		 this.cinemaSeatRepository.deleteById(cinemaSeatId);
	}

}
