package com.spaient.kafka.engines;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(String message) {
		logger.info(String.format("### -> Consuming Message %s", message));		
	}

}
