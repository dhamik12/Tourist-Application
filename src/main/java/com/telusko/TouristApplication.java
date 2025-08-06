package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.Info;
@SpringBootApplication
@OpenAPIDefinition(info=@Info(
					title="Tourist API",
					version="v1.0",
					description="This API will store & retrive tourist date."
				),
		servers=@Server(
		
				url="http://localhost:8089/touristapp",
				description="This API is deployed in follwoing url location."
				
				)
		
		
		
		)
public class TouristApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouristApplication.class, args);
	}

}
