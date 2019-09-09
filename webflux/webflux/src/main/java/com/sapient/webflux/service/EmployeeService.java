package com.sapient.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.webflux.dao.EmployeeDAO;
import com.sapient.webflux.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public void create(Employee employee) {
		employeeDAO.save(employee).subscribe();		
	}

	@Override
	public Flux<Employee> findByName(String name) {
		return employeeDAO.findByName(name);
	}

	@Override
	public Mono<Employee> findById(Integer id) {
		return employeeDAO.findById(id);
	}

	@Override
	public Mono<Employee> update(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Override
	public void delete(Integer id) {
		employeeDAO.deleteById(id);
	}

	@Override
	public Flux<Employee> findAll() {
		return employeeDAO.findAll();
	}

}
