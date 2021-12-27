package com.movie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.demo.domain.CinemaSeat;

@Repository
public interface CinemaSeatRepository extends JpaRepository<CinemaSeat, Integer>{

}
