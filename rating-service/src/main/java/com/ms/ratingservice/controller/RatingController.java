package com.ms.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.ratingservice.entities.Ratings;
import com.ms.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	//create
	@PostMapping
	public ResponseEntity<Ratings> create(@RequestBody Ratings ratings){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.creaRatings(ratings));
	}
	
	//Get All rating
	@GetMapping
	public ResponseEntity<List<Ratings>> getAllRatings(){
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	
	//get all by hotel Id
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Ratings>> getAllByHotelId( @PathVariable Long hotelId){
		return ResponseEntity.ok(ratingService.getAllRatingsByHotelId(hotelId));
	}
	
	
	//get all by user id
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Ratings>> getAllByUserId( @PathVariable Long userId){
		return ResponseEntity.ok(ratingService.getAllRatingsByUserId(userId));
	}
}
