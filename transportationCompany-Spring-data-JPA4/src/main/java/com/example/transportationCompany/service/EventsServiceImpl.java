package com.example.transportationCompany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transportationCompany.dao.EventsRepository;
import com.example.transportationCompany.entity.Events;

@Service
public class EventsServiceImpl implements EventsService {

	
	private EventsRepository eventsRepository;
	
	@Autowired
	public EventsServiceImpl(EventsRepository theEventsRepository) {
		super();
		this.eventsRepository = theEventsRepository;
	}

	@Override
	public List<Events> findAll() {
		return eventsRepository.findAll();
	}

	@Override
	public Events findById(int theId) {
		Optional<Events> result = eventsRepository.findById(theId);
		
		Events events = null;
		if (result.isPresent()) {
			events = result.get();
		}
		else {
			throw new RuntimeException("didn't find event ID - " + theId);
		}
		return events;
	}

	@Override
	public void save(Events theEvent) {
		eventsRepository.save(theEvent);
	}

	@Override
	public void deleteById(int theId) {
		eventsRepository.deleteById(theId);
	}

}
