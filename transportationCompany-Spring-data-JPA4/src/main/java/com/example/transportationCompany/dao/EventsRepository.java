package com.example.transportationCompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.transportationCompany.entity.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {

}
