package com.movie.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.Movie;
import com.movie.demo.domain.State;
import com.movie.demo.repository.StateRepository;
import com.movie.demo.service.StateService;
import com.movie.demo.service.dto.StateDTO;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service("stateService")
@Transactional
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;

	@Override
	public State saveState(StateDTO stateDto) {
		State state=new State();
		BeanUtils.copyProperties(stateDto, state);
		return stateRepository.save(state);
	}

	@Override
	public List<State> getAllStates() {
		// TODO Auto-generated method stub
		return this.stateRepository.findAll();
	}

	@Override
	public State getStateById(Integer stateId) {
		// TODO Auto-generated method stub
		return this.stateRepository.findById(stateId).get();
	}

}
