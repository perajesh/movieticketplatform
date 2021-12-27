package com.movie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.demo.domain.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer>{

}
