package com.zomato.deliveryboy;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	private Logger Logger= LoggerFactory.getLogger(KafkaService.class);
	
	public boolean updateLocation(String location)
	{
		kafkaTemplate.send(AppConstants.LOCATION_UPDATE_TOPIC, location);
		Logger.info("message is produced");
		return true;
		
	}

}
