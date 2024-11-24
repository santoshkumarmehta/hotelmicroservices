package com.ms.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ms.ratingservice.entities.Ratings;

public interface RatingRepository extends JpaRepository<Ratings, Long>{

	
	//Custom methods
	List<Ratings> findByUserid(Long userid);
	
	List<Ratings> findByHotelid(Long hotelid);
	
}
