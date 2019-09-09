package com.spaient.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
@EnableEurekaClient
public class KafkaApplication implements ApplicationRunner, CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(KafkaApplication.class);
	
	public static void main(String[] args) {
		logger.info("Spring bean starting there configuration");
		SpringApplication.run(KafkaApplication.class, args);
		logger.info("Spring bean finish there configuration");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.print("Welcome to Applicaton Runner Interface");		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome to Command Line Runner Interface");
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products").allowedOrigins("http://localhost:9090");
			}
		};
	}

}
