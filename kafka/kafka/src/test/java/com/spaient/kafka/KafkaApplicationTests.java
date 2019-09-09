package com.spaient.kafka;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.spaient.kafka.models.Product;
import com.spaient.kafka.repository.ProductDB;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {

	@Autowired 
	private RestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
	}	
	
	@Test
	@Ignore
	public void interfaceTest() {
		System.out.println(ProductDB.getDatabase());
	}
	
	
	@Test
	
	public void productListTest() {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> mediaTypeList = new ArrayList<>();
		mediaTypeList.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypeList);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		String listValue = restTemplate.exchange("http://localhost:9090/products", HttpMethod.GET, 
				entity, String.class).getBody();
		Assert.assertNotNull(listValue);
	}
	
	@Test
	public void createProductTest() {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> mediaTypeList = new ArrayList<>();
		mediaTypeList.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypeList);
		Product product = new Product("4", "Deepak");		
		HttpEntity<Product> entity = new HttpEntity<>(product, headers);
		
		String listValue = restTemplate.exchange("http://localhost:9090/products", HttpMethod.POST, 
				entity, String.class).getBody();
		Assert.assertNotNull(listValue);
	}
	
	@Test
	public void updateProductTest() {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> mediaTypeList = new ArrayList<>();
		mediaTypeList.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypeList);
		Product product = new Product("2", "Deep");		
		HttpEntity<Product> entity = new HttpEntity<>(product, headers);
		String id = "2";
		String listValue = restTemplate.exchange("http://localhost:9090/products/" + id, HttpMethod.PUT, 
				entity, String.class).getBody();
		Assert.assertNotNull(listValue);
	}
}
