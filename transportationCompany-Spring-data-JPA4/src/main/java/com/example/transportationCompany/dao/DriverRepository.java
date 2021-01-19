package com.example.transportationCompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.transportationCompany.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver , Integer>{
	
	

}
