package com.movie.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_movie")
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2022057965668210449L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movieId")
	private Integer movieId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "releaseDate")
	private LocalDate releaseDate;

	@Column(name = "genre")
	private String genre;
	
	@Column(name = "country")
	private String country;
	

	
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Show> shows;
    
    public Movie() {
    	
    }

	public Movie(Integer movieId, String title, String description, Integer duration, LocalDate releaseDate, String genre,
			String country, Set<Show> shows) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.country = country;
		this.shows = shows;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Show> getShows() {
		return shows;
	}

	public void setShows(Set<Show> shows) {
		this.shows = shows;
	}
    
    

}
