package com.example.transportationCompany.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Events {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="event_id")
	private String eventId;
	
	@Column(name="event_date")
	private Date eventDate;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street")
	private String street;
	
	@Column(name="other_vehicle_id")
	private String otherVehicleId;
	
	@Column(name="fine")
	private String fine;
	
	@Column(name="couse")
	private String couse;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Events(int id, String eventId, Date eventDate, String city, String street, String otherVehicleId,
			String fine, String couse, Vehicle vehicle) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.eventDate = eventDate;
		this.city = city;
		this.street = street;
		this.otherVehicleId = otherVehicleId;
		this.fine = fine;
		this.couse = couse;
		this.vehicle = vehicle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getOtherVehicleId() {
		return otherVehicleId;
	}

	public void setOtherVehicleId(String otherVehicleId) {
		this.otherVehicleId = otherVehicleId;
	}

	public String getFine() {
		return fine;
	}

	public void setFine(String fine) {
		this.fine = fine;
	}

	public String getCouse() {
		return couse;
	}

	public void setCouse(String couse) {
		this.couse = couse;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", eventId=" + eventId + ", eventDate=" + eventDate + ", city=" + city + ", street="
				+ street + ", otherVehicleId=" + otherVehicleId + ", fine=" + fine + ", couse=" + couse + ", vehicle="
				+ vehicle + "]";
	}

}
