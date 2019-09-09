package com.spaient.kafka.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.spaient.kafka.exception.ProductNotFoundException;
import com.spaient.kafka.models.Product;
import com.spaient.kafka.repository.ProductDB;

@Service
public class ProductServiceImpl implements ProductService {
	
	Map<String, Product> map = ProductDB.getDatabase();	
	@Override
	public void updateProduct(String id, Product product) {
		if(map.containsKey(id))
		map.put(id, product);
		else throw new ProductNotFoundException();
	}

	@Override
	public void deleteProduct(String id) {
		map.remove(id);		
	}

	@Override
	public void createProduct(Product product) {
		map.put(product.getId(), product);		
	}

	@Override
	public Map<String, Product> getProduct() {
		return map;
	}

}
