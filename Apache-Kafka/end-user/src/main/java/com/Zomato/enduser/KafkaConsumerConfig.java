package com.Zomato.enduser;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {

	
	@KafkaListener(topics=AppConstants.UPDATED_LOCATION_TOPIC,groupId=AppConstants.GROUP_ID)
	public void updatedLocation(String value)
	{
		System.out.println(value);
	}
}
