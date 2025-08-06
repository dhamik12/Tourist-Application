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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.Tourist;
import com.telusko.service.ITouristService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name="Tourist Controller",
	description="This API will store & retrive tourist date.")
public class TouristController {
	
	@Autowired
	private ITouristService service;
	
	
	@PostMapping("/registration")
	@Operation(summary="Post Operation", description="This method will take Tourist type input & store in database, Return type= Tourist type tourist")
	public ResponseEntity<Tourist> registerTourist(@RequestBody Tourist tour){
		Tourist tourist = new Tourist(tour.getName(), tour.getBudget(), tour.getCity(), tour.getPackageType());
		Tourist registeredTourist = service.registerTourist(tourist);
		return new ResponseEntity<Tourist>(registeredTourist,HttpStatus.CREATED);	
	}
	
	 
	@GetMapping("/view-all-record")
	@Operation(summary="Get Operation", description="This method will return all the records in tourist database.")
	public ResponseEntity<List> displayAllTourist(){
		List<Tourist> touristList = service.displayAllTourist();
		return new ResponseEntity<List>(touristList,HttpStatus.OK);	
	}
	
	@PutMapping("/update")
	@Operation(summary="Put Operation", description="This method will update existing records in tourist database.")
	public ResponseEntity<Tourist> updateTouristInfo(@RequestBody Tourist tourist){
		
		Tourist updatedTourist = service.updateTourist(tourist);
		return new ResponseEntity<Tourist>(updatedTourist,HttpStatus.OK);	
	}
	
	@GetMapping("/find-by-city/{city}")
	@Operation(summary="Get Operation", description="This method will find tourist by city from tourist database.")
	public ResponseEntity<List> getTouristbyCity(@PathVariable String city){
		
		System.out.println("You searched for :"+city);
		List<Tourist> touristList = service.searchTouristByCity(city);
		System.out.println("Controller returned"+ touristList);
		return new ResponseEntity<List>(touristList,HttpStatus.OK);	
	}
	
	

}
