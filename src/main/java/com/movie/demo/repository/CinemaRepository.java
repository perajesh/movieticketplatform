package com.movie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.demo.domain.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

	Cinema findByName(String name);
}
