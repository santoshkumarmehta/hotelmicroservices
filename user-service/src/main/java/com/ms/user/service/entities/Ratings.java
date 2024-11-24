package com.ms.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ratings {

	private Long ratingId;
	private Long userid;
	private Long hotelid;
	private int rating;
	private String feedback;
	
	private Hotel hotel;
	
	
}
