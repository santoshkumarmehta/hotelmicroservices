package com.ms.user.service.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.user.service.entities.Hotel;
import com.ms.user.service.entities.Ratings;
import com.ms.user.service.entities.User;
import com.ms.user.service.exceptions.ResourceNotFoundException;
import com.ms.user.service.external.services.HotelService;
import com.ms.user.service.external.services.RatingService;
import com.ms.user.service.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

		
	@Override
	public User saveUser(User user) {
		
		ratingService.createRating(user.getRatingObj());
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User getUserID(Long userid) {
		User user = userRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with this id " + userid));

		// Calling Rating service
		// get all ratings by userId
		// http://localhost:8083/ratings/users/1

		Ratings[] ratingList = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userid,	Ratings[].class);
		List<Ratings> arrList=Arrays.asList(ratingList);
//		user.setRatings(arrList);
		logger.info("{}" + arrList);
//		return user;

		
		
		//Using rest template
		/*
		 * List<Ratings> list=arrList.stream().map(rating->{ ResponseEntity<Hotel>
		 * entity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.
		 * getHotelid(), Hotel.class); Hotel hotel = entity.getBody();
		 * rating.setHotel(hotel);
		 * 
		 * return rating; }).collect(Collectors.toList());
		 * 
		 * // set hotel into rating // return the rating // return rating
		 * 
		 * user.setRatings(list); return user;
		 */
		 
		
		// Using Feign Client
		List<Ratings> list=arrList.stream().map(rating->{ 
		Hotel hotel = hotelService.getHotel(rating.getHotelid());
		rating.setHotel(hotel);
		return rating;
		}).collect(Collectors.toList());
		user.setRatings(list);
		return user;	
	}

	
}
