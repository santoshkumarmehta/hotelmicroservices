package com.ms.hotelservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.hotelservice.entity.Hotel;
import com.ms.hotelservice.exception.ResourceNotFoundException;
import com.ms.hotelservice.repositories.HotelRepository;
import com.ms.hotelservice.service.HotelService;


@Service
public class HotelserviceImp implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		Hotel saveHotel =hotelRepository.save(hotel);
		return saveHotel;
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
		
	}

	@Override
	public Hotel getById(long id) {
		return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id not found"));
	}

}
