package com.telusko.advice;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telusko.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristControllerAdvice {
	
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ErrorDetails touristNotFoundException(TouristNotFoundException tnf) {
		
		ErrorDetails error=new ErrorDetails(tnf.getMessage(),LocalDateTime.now());
		return error;	
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ErrorDetails touristNotFoundException(Exception e) {
		
		ErrorDetails error=new ErrorDetails(e.getMessage(),LocalDateTime.now());
		return error;	
	}
	

}
