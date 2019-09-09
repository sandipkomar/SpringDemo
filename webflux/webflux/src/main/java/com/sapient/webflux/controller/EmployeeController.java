package com.sapient.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.webflux.model.Employee;
import com.sapient.webflux.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody Employee employee) {
		employeeService.create(employee);
	}
	
	@GetMapping(value = "/name/{name}")
	@ResponseBody
	public Flux<Employee> findByName(@PathVariable("name") String name) {
		return employeeService.findByName(name);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id) {
		Mono<Employee> employee = employeeService.findById(id);
		HttpStatus status = (employee != null)?HttpStatus.OK: HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Employee>>(employee, status);
	}
	
	@PutMapping(value ="/update")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> update(Employee employee) {
		return employeeService.update(employee);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Integer id) {
		employeeService.delete(id);
	}
	
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<Employee> findAll(){
		return employeeService.findAll();
	}
	
}
