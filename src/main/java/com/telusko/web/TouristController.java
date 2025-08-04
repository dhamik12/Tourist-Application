package com.telusko.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.Tourist;
import com.telusko.service.ITouristService;


@RestController
//@RequestMapping("/tourist-controller")
public class TouristController {
	
	@Autowired
	private ITouristService service;
	
	
	@PostMapping("/registration")
	public ResponseEntity<Tourist> registerTourist(@RequestBody Tourist tourist){
		
		Tourist registeredTourist = service.registerTourist(tourist);
		return new ResponseEntity<Tourist>(registeredTourist,HttpStatus.CREATED);	
	}
	
	
	@GetMapping("/view-all-record")
	public ResponseEntity<List> displayAllTourist(){
		
		List<Tourist> touristList = service.displayAllTourist();
		return new ResponseEntity<List>(touristList,HttpStatus.OK);	
	}
	
	@PutMapping("/update")
	public ResponseEntity<Tourist> updateTouristInfo(@RequestBody Tourist tourist){
		
		Tourist updatedTourist = service.updateTourist(tourist);
		return new ResponseEntity<Tourist>(updatedTourist,HttpStatus.OK);	
	}
	
	@GetMapping("/find-by-city/{city}")
	public ResponseEntity<List> getTouristbyCity(@PathVariable("city")String city){
		
		System.out.println("You searched for :"+city);
		List<Tourist> touristList = service.searchTouristByCity(city);
		System.out.println("Controller returned"+ touristList);
		return new ResponseEntity<List>(touristList,HttpStatus.OK);	
	}
	
	

}
