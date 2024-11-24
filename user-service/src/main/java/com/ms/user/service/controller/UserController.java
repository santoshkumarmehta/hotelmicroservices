package com.ms.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.service.entities.User;
import com.ms.user.service.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	
	// create user
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User createdUser=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	int retryCount=1;
	// get user
	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelsBreaker", fallbackMethod = "ratingHotelfallback")
//	@Retry(name = "ratingHotelsRetry", fallbackMethod = "ratingHotelfallback")
	@RateLimiter(name = "ratingHotelRateLimiter", fallbackMethod = "ratingHotelfallback")
	public ResponseEntity<User> getUserById(@PathVariable Long userId){
		System.out.println(retryCount);
		retryCount++;
		User getUser= userService.getUserID(userId);
		return ResponseEntity.ok(getUser);
		
	}
	
	//get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers=userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	
	// creating fall back method
	
	public ResponseEntity<User> ratingHotelfallback(Long userId, Exception ex){
		
	System.out.println("Fallback is executed "+ ex.getMessage());
		
		User user =new  User();
		user.setName("Dummy");
		user.setEmail("dummy@gmail.com");
		user.setUserId((long) 123);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
		
		
	}
}
