package com.example.transportationCompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.transportationCompany.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle , Integer>{
	
	

}
