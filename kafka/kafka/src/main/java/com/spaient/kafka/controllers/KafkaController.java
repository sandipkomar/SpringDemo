package com.spaient.kafka.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spaient.kafka.engines.Producer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	
	private final Producer producer;
	
	public KafkaController(Producer producer) {
		this.producer= producer;
	}
	
	@PostMapping(value = "/publish")
	public void sendMessageToKafka(@RequestParam(value = "message", required = false, 
	defaultValue = "hello") String message) {
		for(int i = 0; i<100; i++)
		this.producer.sendMessage(message);
	}

}
