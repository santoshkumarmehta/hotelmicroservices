package com.ms.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.service.payload.APIResponse;

@ControllerAdvice
public class GlobalExceptionsHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> handleResourceNotFoundExeption(ResourceNotFoundException ex){
		
		String message=ex.getMessage();
	 APIResponse apiResponse= APIResponse.builder().message(message).status(HttpStatus.NOT_FOUND).build();
			 
		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
}
