package com.zomato.deliveryboy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class Locationcontroller {
	
	@Autowired
	private KafkaService  kafkaService;
	
	@PostMapping("/update")
	public ResponseEntity<?> updatedLocation()
	{
		for(int i=0;i<100000;i++) {
		kafkaService.updateLocation("( "+Math.round(Math.random()*100)+" , "+Math.round(Math.random()*100)+" )");}
		return new ResponseEntity<>(Map.of("message","location updated"),HttpStatus.OK);
		
	}
	
	

}
