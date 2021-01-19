package com.example.transportationCompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.transportationCompany.entity.Events;
import com.example.transportationCompany.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer>{

}
