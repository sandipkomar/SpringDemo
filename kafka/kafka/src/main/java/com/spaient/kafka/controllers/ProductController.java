package com.spaient.kafka.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spaient.kafka.models.Product;
import com.spaient.kafka.service.ProductService;

@RestController
@RequestMapping(value = "/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PutMapping(value = "/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		productService.updateProduct(id, product);
		return new ResponseEntity<>("Product Updated Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
	}
	
	@PostMapping(value = "/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<>("Product created Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		Map<String, Product> map = productService.getProduct();
		return new ResponseEntity<>(map.values(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
		Map<String, Product> map = productService.getProduct();
		if(map.get(id) == null)			
			return new ResponseEntity<>("Product with this id is not found in database", HttpStatus.OK);
		return new ResponseEntity<>(map.get(id), HttpStatus.OK);
	}
	
}
