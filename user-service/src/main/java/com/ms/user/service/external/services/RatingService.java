package com.ms.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ms.user.service.entities.Ratings;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	
	//get method
	
	
	//post method
	@PostMapping("/ratings")
	public Ratings createRating(Ratings ratings);
	
	
	//put method
	@PutMapping("/ratings/{feedback}")
	public Ratings putRating(@PathVariable String feedback, Ratings ratings);
	
	//Delete method
	@DeleteMapping("/ratings/{ratingId}")
	public void deleterating(@PathVariable("ratingId") Long id);// we have to pass @pathvariable parameter when both id not matched.
	
}
