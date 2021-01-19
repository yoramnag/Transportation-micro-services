package com.example.transportationCompany.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.transportationCompany.entity.Driver;
import com.example.transportationCompany.entity.Training;
import com.example.transportationCompany.entity.Vehicle;
import com.example.transportationCompany.service.DriverService;
import com.example.transportationCompany.service.TrainingService;


@RestController
@RequestMapping("/api")
public class TrainingRestController {
	
	private TrainingService trainingService;
	private DriverService driverService;

	public TrainingRestController(TrainingService theTrainingService,DriverService theDriverService) {
		super();
		this.trainingService = theTrainingService;
		this.driverService = theDriverService;
	}
	
	// expose "/training" and return list of training
	@GetMapping("/training")
	public List<Training> findAll() {
		return trainingService.findAll();
	}
	
	// add mapping for GET /training/{trainingID}
	
	@GetMapping("/training/{trainingID}")
	public Training getDriver(@PathVariable int trainingID) {
		
		Training theTraining = trainingService.findById(trainingID);
		
		if (theTraining == null) {
			throw new RuntimeException("training id not found - " + trainingID);
		}
		
		return theTraining;
	}
	
	// add mapping for POST /training - add new training
	
	@PostMapping("/training")
	public Training addTraining(@RequestBody Training training) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		Driver theDriver = driverService.findById(training.getDriver().getId());
		//System.out.println(theDriver.getFirstName());
		

		Training theTraining = new Training();
		theTraining.setId(0);
		
		theTraining.setCourseTitle(training.getCourseTitle());
		theTraining.setStartDate(training.getStartDate());
		theTraining.setEndDate(training.getEndDate());
		theTraining.setNumberOfParticipants(training.getNumberOfParticipants());
		theTraining.setMaxNumberOfParticipants(training.getMaxNumberOfParticipants());
		theTraining.setDriver(theDriver);
		trainingService.save(theTraining);
		
		
		return theTraining;

	}
	
	@PutMapping("/training")
	public Training updatevVehicle(@RequestBody Training theTraining) {
		driverService.findById(theTraining.getDriver().getId());
		trainingService.save(theTraining);
		
		return theTraining;
	}
	
	@DeleteMapping("/training/{trainingId}")
	public String deleteTraining(@PathVariable int trainingId) {
		
		Training tempTraining = trainingService.findById(trainingId);
		
		if (tempTraining == null) {
			throw new RuntimeException("Training id not found - " + trainingId);
		}
		
		trainingService.deleteById(trainingId);
		
		return "Deleted Training id - " + trainingId;
		
	}
	
	
	
	
	
	

}
