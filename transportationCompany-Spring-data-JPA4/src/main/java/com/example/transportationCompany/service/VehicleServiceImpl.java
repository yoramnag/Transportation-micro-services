package com.example.transportationCompany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transportationCompany.dao.VehicleRepository;
import com.example.transportationCompany.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	private VehicleRepository vehicleRepository;
	
	@Autowired
	public VehicleServiceImpl(VehicleRepository theVehicleRepository) {
		super();
		this.vehicleRepository = theVehicleRepository;
	}

	@Override
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle findById(int theId) {
		Optional<Vehicle> result = vehicleRepository.findById(theId);
		
		Vehicle vehicle = null;
		
		if (result.isPresent()) {
			vehicle =  result.get();
		} else {
			throw new RuntimeException("didn't find vehicle ID - " + theId);
		}
		return vehicle;
	}

	@Override
	public void save(Vehicle theVehicle) {
		vehicleRepository.save(theVehicle);
	}

	@Override
	public void deleteById(int theId) {
		vehicleRepository.deleteById(theId);
	}

}
