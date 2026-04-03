package com.flights.model;

public class Flight{
	
	String airline;
	 double fare;
	 
	 

	public Flight(String airline,double fare) {
		 
		 this.airline = airline;
		 this.fare = fare;
	 }
	
	@Override
	public String toString() {
		return "Flight [airline=" + airline + ", fare=" + fare + "]";
	}

	
	 
	 

}
