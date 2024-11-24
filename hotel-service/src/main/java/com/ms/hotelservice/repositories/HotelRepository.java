package com.ms.hotelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hotelservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
