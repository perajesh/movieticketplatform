package com.movie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.demo.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

	State findByStateName(String stateName);
}
