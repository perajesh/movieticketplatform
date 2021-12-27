package com.movie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.demo.domain.CinemaHall;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer>{

}
