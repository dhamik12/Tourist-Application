package com.telusko.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Tourist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String name;
	private Double budget;
	private String city;
	private String packageType;
	
	public Tourist(String name, Double budget, String city, String packageType) {
		super();
		this.name = name;
		this.budget = budget;
		this.city = city;
		this.packageType = packageType;
	}
	
	

}
