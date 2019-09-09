package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCFController {
	
	@GetMapping(value = "/hello")
	public String helloMessage(@RequestParam("hello") String message) {
		return "hello for cf: " + message;
	}
}
