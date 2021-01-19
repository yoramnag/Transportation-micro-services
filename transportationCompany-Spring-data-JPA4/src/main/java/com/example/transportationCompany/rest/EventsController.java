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
import com.example.transportationCompany.entity.Events;
import com.example.transportationCompany.entity.Vehicle;
import com.example.transportationCompany.service.EventsService;
import com.example.transportationCompany.service.VehicleService;

@RestController
@RequestMapping("/api")
public class EventsController {
	
	private VehicleService vehicleService;
	private EventsService eventsService;
	
	@Autowired
	public EventsController(VehicleService vehicleService, EventsService eventsService) {
		super();
		this.vehicleService = vehicleService;
		this.eventsService = eventsService;
	}
	
	
	// expose "/events" and return list of events
	@GetMapping("/events")
	public List<Events> findAll() {
		return eventsService.findAll();
	}
	
	// add mapping for GET /events/{eventId}
	@GetMapping("/events/{eventId}")
	public Events getDriver(@PathVariable int eventId) {
		
		Events theEvent = eventsService.findById(eventId);
		
		if (theEvent == null) {
			throw new RuntimeException("event id not found - " + eventId);
		}
		
		return theEvent;
	}
	
	@PostMapping("/events")
	public Events addEvent(@RequestBody Events event) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		Vehicle theVehicle = vehicleService.findById(event.getVehicle().getId());
		//System.out.println(theDriver.getFirstName());
		
		Events theEvent = new Events();
		theEvent.setId(0);
		
		theEvent.setEventId(event.getEventId());
		theEvent.setCity(event.getCity());
		theEvent.setCouse(event.getCouse());
		theEvent.setEventDate(event.getEventDate());
		theEvent.setFine(event.getFine());
		theEvent.setOtherVehicleId(event.getOtherVehicleId());
		theEvent.setStreet(event.getStreet());
		theEvent.setVehicle(theVehicle);
		eventsService.save(theEvent);
		return theEvent;

	}
	@PutMapping("/events")
	public Events updateEvent(@RequestBody Events theEvent) {
		Vehicle theVehicle = vehicleService.findById(theEvent.getVehicle().getId());
		theEvent.setVehicle(theVehicle);
		eventsService.save(theEvent);
		
		return theEvent;
	}
	
	@DeleteMapping("/events/{eventId}")
	public String deleteEvent(@PathVariable int eventId) {
		Events tempEvent = eventsService.findById(eventId);
		
		if (tempEvent == null) {
			throw new RuntimeException("event id not found - " + eventId);
		}
		
		eventsService.deleteById(eventId);
		
		return "Delete event id " + eventId;
		
	}
	
}
