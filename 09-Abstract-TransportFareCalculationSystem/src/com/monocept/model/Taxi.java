package com.monocept.model;

import java.time.LocalDateTime;

public class Taxi extends Transport {

	private int distance;
	private int time;
	
	private double ratePerKm = 10;
	private double ratPerMinute = 2;

	public Taxi(int routeId,int distance,int time) {
		super(routeId,distance);
		this.time = time;
	}

	@Override
	public double calculateFare() {

		return baseFare +(distance * ratePerKm) +(time * ratPerMinute);

	}

}
