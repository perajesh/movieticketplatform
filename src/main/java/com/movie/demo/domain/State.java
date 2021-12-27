package com.movie.demo.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_states")
public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7807241135870306239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "state_name")
	private String stateName;

	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<City> cities;

	public State() {

	}

	public State(Integer stateId, String stateName, Set<City> cities) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		this.cities = cities;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}
