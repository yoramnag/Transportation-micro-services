package com.example.transportationCompany.service;

import java.util.List;

import com.example.transportationCompany.entity.Training;

public interface TrainingService {
	
	public List<Training> findAll();
	
	public Training findById(int theId);
	
	public void save (Training theTraining);
	
	public void deleteById(int theId);
}
