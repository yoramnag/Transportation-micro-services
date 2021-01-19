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
import com.example.transportationCompany.entity.Vehicle;
import com.example.transportationCompany.service.DriverService;
import com.example.transportationCompany.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleRestController {
	
	private VehicleService vehicleService;
	private DriverService driverService;

	@Autowired
	public VehicleRestController(VehicleService theVehicleService,DriverService theDriverService) {
		this.vehicleService = theVehicleService;
		this.driverService = theDriverService;
	}
	
	// expose "/vehicles" and return list of vehicles
	@GetMapping("/vehicles")
	public List<Vehicle> findAll() {
		return vehicleService.findAll();
	}
	
	// add mapping for GET /vehicles/{vehicleId}
	
	@GetMapping("/vehicles/{vehicleId}")
	public Vehicle getVehicle(@PathVariable int vehicleId) {
		
		Vehicle theVehicle = vehicleService.findById(vehicleId);
		
		if (theVehicle == null) {
			throw new RuntimeException("vehicle id not found - " + vehicleId);
		}
		
		return theVehicle;
	}
	
//	// add mapping for POST /vehicles/{driverId}/{plateNumber}/{vehicleType} - add new vehicle
//	
//	@PostMapping("/vehicles/{driverId}/{plateNumber}/{vehicleType}")
//	public Vehicle addDriver(@PathVariable int driverId, @PathVariable String plateNumber , @PathVariable String vehicleType) {
//		
//		// also just in case they pass an id in JSON ... set id to 0
//		// this is to force a save of new item ... instead of update
//		
//		Driver theDriver = driverService.findById(driverId);
//		System.out.println(theDriver.getFirstName());
//		
//		Vehicle theVehicle = new Vehicle();
//		theVehicle.setId(0);
//		
//		theVehicle.setPlateNumber(plateNumber);
//		theVehicle.setVehicleType(vehicleType);
//		theVehicle.setDriver(theDriver);
//		vehicleService.save(theVehicle);
//		return theVehicle;
//
//	}
	
	// add mapping for POST /vehicles - add new vehicle
	
	@PostMapping("/vehicles")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		Driver theDriver = driverService.findById(vehicle.getDriver().getId());
		//System.out.println(theDriver.getFirstName());
		
		Vehicle theVehicle = new Vehicle();
		theVehicle.setId(0);
		
		theVehicle.setPlateNumber(vehicle.getPlateNumber());
		theVehicle.setVehicleType(vehicle.getVehicleType());
		theVehicle.setDriver(theDriver);
		vehicleService.save(theVehicle);
		return theVehicle;

	}
	
	@PutMapping("/vehicles")
	public Vehicle updatevVehicle(@RequestBody Vehicle theVehicle) {
		Driver theDriver = driverService.findById(theVehicle.getDriver().getId());
		theVehicle.setDriver(theDriver);
		vehicleService.save(theVehicle);
		
		return theVehicle;
	}
	
	@DeleteMapping("/vehicles/{vehicleId}")
	public String deleteVehicle(@PathVariable int vehicleId) {
		
		Vehicle tempVehicle = vehicleService.findById(vehicleId);
		
		// throw exception if null
		
		if (tempVehicle == null) {
			throw new RuntimeException("Vehicle id not found - " + vehicleId);
		}
		
		vehicleService.deleteById(vehicleId);
		
		return "Deleted vehicle id - " + vehicleId;
	}
	
	
	

}
