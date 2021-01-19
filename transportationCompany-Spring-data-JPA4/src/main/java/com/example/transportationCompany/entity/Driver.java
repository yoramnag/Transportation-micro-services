package com.example.transportationCompany.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="driver")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class , property="id")
@JsonIgnoreProperties(value = { "vehicles" })
public class Driver implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6636776954812908486L;

	// define fields
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column(name="email")
		private String email;
		
		@JsonIgnore
		@JsonSerialize
		@Lazy
		@OneToMany(fetch = FetchType.LAZY ,mappedBy="driver",
				   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
							 CascadeType.DETACH, CascadeType.REFRESH})
		private List<Vehicle> Vehicles;
		
		@JsonIgnore
		@JsonSerialize
		@Lazy
		@OneToMany(fetch = FetchType.LAZY ,mappedBy="driver",
				   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
							 CascadeType.DETACH, CascadeType.REFRESH})
		private List<Training> training;
		
		public Driver() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Driver(String firstName, String lastName, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
		
		public List<Vehicle> getVehicles() {
			return Vehicles;
		}

		public void setVehicles(List<Vehicle> vehicles) {
			Vehicles = vehicles;
		}
		
		public void add(Vehicle tempVehicle) {
			if (Vehicles == null) {
				Vehicles = new ArrayList<Vehicle>();
			}
			
			Vehicles.add(tempVehicle);
			tempVehicle.setDriver(this);
		}
		
		public void add(Training tempTraining) {
			if (training == null) {
				training = new ArrayList<Training>();
			}
			
			training.add(tempTraining);
			tempTraining.setDriver(this);
		}

		@Override
		public String toString() {
			return "Driver [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+"]";
		}
		
		
		
		
		
		
		
		
		
		
}
