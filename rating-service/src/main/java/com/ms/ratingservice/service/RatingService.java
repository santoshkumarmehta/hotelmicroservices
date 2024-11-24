package com.ms.ratingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.ratingservice.entities.Ratings;


public interface RatingService{
	
	//create
	Ratings creaRatings(Ratings ratings);
	
	//Get all ratings
	List<Ratings> getAllRatings();
	
	//Get all ratings by User Id
	List<Ratings> getAllRatingsByUserId(Long id);
	
	//get all rating by hotelid
	List<Ratings> getAllRatingsByHotelId(Long id);
	

}
