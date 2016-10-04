package com.tutorialspoint.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaggageItem {
	private String id, passengerId;
	private String weight, flightNumber, from, to, departureDateAndTime, airline;

	public BaggageItem(){
		super();
	}

	public BaggageItem(String id, String passengerId, String weight, String flightNumber, String from, String to, String departureDateAndTime,
			String airline) {
		super();
		this.id = id;
		this.passengerId = passengerId;
		this.weight = weight;
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.departureDateAndTime = departureDateAndTime;
		this.airline = airline;
	}


	public BaggageItem(String passengerId, String weight, String flightNumber, String from, String to, String departureDateAndTime,
			String airline) {
		super();
		this.passengerId = passengerId;
		this.weight = weight;
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.departureDateAndTime = departureDateAndTime;
		this.airline = airline;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassengerId() {
		return passengerId;
	}


	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getDepartureDateAndTime() {
		return departureDateAndTime;
	}


	public void setDepartureDateAndTime(String departureDateAndTime) {
		this.departureDateAndTime = departureDateAndTime;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	
}
