package com.spaient.kafka.repository;

import java.util.HashMap;
import java.util.Map;

import com.spaient.kafka.models.Product;

public interface ProductDB {	
	Map<String, Product> map = new HashMap<>();	
	static Map<String, Product> getDatabase() {
		map.put("1", new Product("1", "Honey"));
		map.put("2", new Product("2", "Bontey"));
		return map;
	}
	
}
