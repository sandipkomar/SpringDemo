package com.sapient.webflux.dao;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sapient.webflux.model.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeDAO extends ReactiveMongoRepository<Employee, Integer>{
	@Query("{'name' : ?0 }")
	public Flux<Employee> findByName(String name);	
}
