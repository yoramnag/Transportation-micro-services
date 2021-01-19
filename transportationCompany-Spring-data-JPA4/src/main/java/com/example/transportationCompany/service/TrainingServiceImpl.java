package com.example.transportationCompany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transportationCompany.dao.TrainingRepository;
import com.example.transportationCompany.entity.Training;

@Service
public class TrainingServiceImpl implements TrainingService {
	
	private TrainingRepository trainingRepository;
	
	@Autowired
	public TrainingServiceImpl(TrainingRepository theTrainingRepository) {
		super();
		this.trainingRepository = theTrainingRepository;
	}

	@Override
	public List<Training> findAll() {
		 return trainingRepository.findAll();
	}

	@Override
	public Training findById(int theId) {
		Optional<Training> result = trainingRepository.findById(theId);
		Training training = null;
		
		if (result.isPresent()) {
			training = result.get();
		}
		else {
			throw new RuntimeException("didn't find training ID - " + theId);
		}
		
		return training;
	}

	@Override
	public void save(Training theTraining) {
		trainingRepository.save(theTraining);
		
	}

	@Override
	public void deleteById(int theId) {
		trainingRepository.deleteById(theId);
		
	}

}
