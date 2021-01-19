package com.example.transportationCompany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.transportationCompany.dao.DriverRepository;
import com.example.transportationCompany.entity.Driver;


@Service
public class DriverServiceImpl implements DriverService {
	
	private DriverRepository driverRepository;
	
	@Autowired
	public DriverServiceImpl(DriverRepository theDriverRepository) {
		super();
		this.driverRepository = theDriverRepository;
	}

	@Override
	public List<Driver> findAll() {
		return driverRepository.findAll();
	}

	@Override
	public Driver findById(int theId) {
		Optional<Driver> result = driverRepository.findById(theId);
		
		Driver theDriver = null;
		
		if (result.isPresent()) {
			theDriver = result.get();
		} else {
			throw new RuntimeException("didn't find driver ID - " + theId);
		}
		return theDriver;
	}

	@Override
	public void save(Driver theDriver) {
		driverRepository.save(theDriver);
	}

	@Override
	public void deleteById(int theId) {
		driverRepository.deleteById(theId);
	}

}
