package com.monocept.model;

public abstract class Transport {

	protected int routeId;
	protected double baseFare;

	public Transport(int routeId, double baseFare) {
		super();
		this.routeId = routeId;
		this.baseFare = baseFare;
	}

	public abstract double calculateFare();

	public void printTicket() {
		System.out.println("====Printing Ticket====");
        double totalFare = calculateFare();
        
        System.out.println("Route Id: "+routeId);
		System.out.println("base Fare: "+baseFare);
		System.out.println("TotalFare: "+totalFare);
	}

}
