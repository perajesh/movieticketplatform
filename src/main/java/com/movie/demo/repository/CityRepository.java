package com.movie.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.demo.domain.City;
import com.movie.demo.domain.State;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
	
	List<City> findByState(State State);

}
