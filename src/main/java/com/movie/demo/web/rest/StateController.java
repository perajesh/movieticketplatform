package com.movie.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.domain.State;
import com.movie.demo.service.StateService;
import com.movie.demo.service.dto.StateDTO;

@RestController
@RequestMapping("/api/state")
public class StateController {

	@Autowired 
	StateService stateService;
	
	@GetMapping("/allstates")
	public ResponseEntity<List<State>> getAllCinemas() {
		return ResponseEntity.ok(this.stateService.getAllStates());
	}
	
	@PostMapping("/addState")
	public ResponseEntity<?> addState(@RequestBody StateDTO stateDTO)  {
		State  state=this.stateService.saveState(stateDTO);
		return ResponseEntity.status(HttpStatus.OK).body(state);
	}
}
