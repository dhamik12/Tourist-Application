package com.telusko.service;

import java.util.List;

import com.telusko.model.Tourist;

public interface ITouristService {
	
	Tourist registerTourist(Tourist tourist);
	Tourist updateTourist(Tourist tourist);
	String removeTouristbyId(Integer id);
	List<Tourist> displayAllTourist();
	List<Tourist> searchTouristByCity(String city);
	
	

}
