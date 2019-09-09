package com.example.demo.sample;

import java.util.Date;

public class Employee {
	String name;
	Date date;
	
	public Employee() {
		
	}
	public Employee(String name, Date date) {
		this.date = date;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public boolean equals(Object object) {
		return true;
	}
	
	@Override
	public String toString() {
		return "Hello";
	}
}
