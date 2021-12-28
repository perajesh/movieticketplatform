package com.movie.demo.web.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.domain.CinemaHall;
import com.movie.demo.domain.CinemaSeat;
import com.movie.demo.domain.City;
import com.movie.demo.domain.Show;
import com.movie.demo.exception.HousefulException;
import com.movie.demo.service.ShowService;
import com.movie.demo.service.dto.CityDTO;
import com.movie.demo.service.dto.ShowDTO;

@RestController
@RequestMapping("/api/show")
public class ShowController {

	@Autowired
	ShowService showService;

	@GetMapping("/shows")
	public ResponseEntity<List<Show>> getAllShows() {
		return ResponseEntity.ok(this.showService.getAllShows());
	}

	@GetMapping("/shows/{showid}")
	public ResponseEntity<?> getShowsByShowId(@PathVariable Integer showid) {
		Show show = this.showService.getShowById(showid);
		return ResponseEntity.status(HttpStatus.OK).body(show);
	}

	@GetMapping("/shows/{show_id}/seats")
	public ResponseEntity<?> getSeatsByShowId(@PathVariable Integer show_id) throws HousefulException {
		List<CinemaSeat> cinemaseats = this.showService.getSeatsByShowId(show_id);
		if (cinemaseats.size() == 0) {
			throw new HousefulException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(cinemaseats);
	}
	
    @GetMapping("/shows/givendates")
    public ResponseEntity<?> getAllScreenings(@RequestParam(required = false) Map<String, String> dates) {
        List<Show> shows = null;
        if(!dates.isEmpty()) {
            LocalDate startDate = LocalDate.parse(dates.get("startDate"));
            LocalDate endDate = LocalDate.parse(dates.get("endDate"));
            shows = this.showService.getAllScreenings(startDate, endDate);
        } else {
        	shows = this.showService.getAllShows();
        }
        return ResponseEntity.status(HttpStatus.OK).body(shows);
    }
    
    @PostMapping("/addshow")
	public ResponseEntity<?> addShow(@RequestBody ShowDTO showDTO)  {
		Show  show=this.showService.addShow(showDTO);
		return ResponseEntity.status(HttpStatus.OK).body(show);
	}
    
    @DeleteMapping("/shows/{showId}")
    public ResponseEntity<?> deleteMovieById(@PathVariable Integer showId) {
        this.showService.deleteShowById(showId);
        return ResponseEntity.noContent().build();
    }

}
