package com.example.transportationCompany.service;

import java.util.List;

import com.example.transportationCompany.entity.Driver;


public interface DriverService {
	
	public List<Driver> findAll();
	
	public Driver findById(int theId);
	
	public void save(Driver theDriver);
	
	public void deleteById(int theId);
}
