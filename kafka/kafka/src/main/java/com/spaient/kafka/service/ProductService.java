package com.spaient.kafka.service;

import java.util.Map;

import com.spaient.kafka.models.Product;

public interface ProductService {

	void updateProduct(String id, Product product);

	void deleteProduct(String id);

	void createProduct(Product product);

	Map<String, Product> getProduct();

}