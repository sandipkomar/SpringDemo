package com.sapient.webflux.service;

import com.sapient.webflux.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
	
	public void create(Employee employee);
	
	public Flux<Employee> findByName(String name);
	
	public Mono<Employee> findById(Integer id);
	
	public Mono<Employee> update(Employee employee);
	
	public void delete(Integer id);
	
	public Flux<Employee> findAll();
	
}
