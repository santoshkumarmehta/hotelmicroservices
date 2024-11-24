package com.ms.ratingservice.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_ratings")
public class Ratings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ratingId")
	private Long ratingId;
	
	@Column(name = "userid")
	private Long userid;
	
	@Column(name = "hotelid")
	private Long hotelid;
	
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "feedback")	
	private String feedback;
}
