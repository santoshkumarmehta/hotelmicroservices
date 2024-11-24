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
public class Hotel {
	
	private Long id;
	
	private String name;
	
	private String location;

	private String about;
}
