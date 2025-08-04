package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.exception.TouristNotFoundException;
import com.telusko.model.Tourist;
import com.telusko.repo.ITouristRepo;
@Service
public class TouristService implements ITouristService {
	
	@Autowired
	private ITouristRepo repo;

	

	@Override
	public Tourist registerTourist(Tourist tourist) {
		
		return repo.save(tourist);
	}

	@Override
	public Tourist updateTourist(Tourist tourist) {
		
		Optional<Tourist> optional = repo.findById(tourist.getId());
		if(optional.isPresent()) {
			return repo.save(tourist);
			
		}
		
		else
			
			throw new TouristNotFoundException("Tourist record is not present with given id :"+tourist.getId());
	}

	@Override
	public String removeTouristbyId(Integer id) {
		
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			
			repo.deleteById(id);
			return "Tourist record is deleted with id:"+ id;
			
		}
		
		else
			
			throw new TouristNotFoundException("Tourist record is not present with given id :"+id);
	}

	@Override
	public List<Tourist> displayAllTourist() {
		return repo.findAll();
	
	}

	@Override
	public List<Tourist> searchTouristByCity(String city) {
				return repo.findByCity(city);
		
	}
		
	}


