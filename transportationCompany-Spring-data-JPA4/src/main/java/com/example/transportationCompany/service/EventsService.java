package com.example.transportationCompany.service;

import java.util.List;

import com.example.transportationCompany.entity.Events;

public interface EventsService {

	public List<Events> findAll();
	
	public Events findById(int theId);
	
	public void save (Events theEvent);
	
	public void deleteById(int theId);
}
