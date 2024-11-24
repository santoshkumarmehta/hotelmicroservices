package com.ms.ratingservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.ratingservice.entities.Ratings;
import com.ms.ratingservice.repository.RatingRepository;
import com.ms.ratingservice.service.RatingService;

@Service
public class RatingServiceImp implements RatingService{

	@Autowired
	RatingRepository ratingRepository;
	
	@Override
	public Ratings creaRatings(Ratings ratings) {
		
		return ratingRepository.save(ratings);
	}

	@Override
	public List<Ratings> getAllRatings() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Ratings> getAllRatingsByUserId(Long id) {
		return ratingRepository.findByUserid(id);
	}

	@Override
	public List<Ratings> getAllRatingsByHotelId(Long id) {
		
		return ratingRepository.findByHotelid(id);
	}

}
