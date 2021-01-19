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
@Table(name="training")
public class Training {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="course_title")
	private String courseTitle;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="number_of_participants")
	private int numberOfParticipants;
	
	@Column(name="max_number_of_participants")
	private int maxNumberOfParticipants;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="tr_driver_id")
	private Driver driver;

	
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCourseTitle() {
		return courseTitle;
	}


	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}


	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}


	public int getMaxNumberOfParticipants() {
		return maxNumberOfParticipants;
	}


	public void setMaxNumberOfParticipants(int maxNumberOfParticipants) {
		this.maxNumberOfParticipants = maxNumberOfParticipants;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	@Override
	public String toString() {
		return "Training [id=" + id + ", courseTitle=" + courseTitle + ", startDate=" + startDate + ", endDate="
				+ endDate + ", numberOfParticipants=" + numberOfParticipants + ", maxNumberOfParticipants="
				+ maxNumberOfParticipants + ", driver=" + driver + "]";
	}
	
}
