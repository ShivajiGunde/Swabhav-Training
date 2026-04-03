package com.monocept.model;

public class Bus extends Transport {

	private int distance;
	private double ratePerKm = 5;

	public Bus(int routeId, double baseFare, int distance) {
		super(routeId, baseFare);
		this.distance = distance;
	}

	@Override
	public double calculateFare() {

		return baseFare + (distance * ratePerKm);
	}

}
