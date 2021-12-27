package com.movie.demo.service;

import java.util.List;

import com.movie.demo.domain.City;
import com.movie.demo.domain.Movie;
import com.movie.demo.domain.State;
import com.movie.demo.service.dto.StateDTO;

public interface StateService {

	List<State> getAllStates();
	State getStateById(Integer stateId);
	public State saveState(StateDTO stateDTO);
}
