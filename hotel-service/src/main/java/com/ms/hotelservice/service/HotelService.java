package com.ms.hotelservice.service;

import java.util.List;

import com.ms.hotelservice.entity.Hotel;

public interface HotelService {

	//create
	Hotel create(Hotel hotel);
	
	//get all 
	List<Hotel> getAll();
	
	//get by id
	Hotel getById(long id);
	
	
}
