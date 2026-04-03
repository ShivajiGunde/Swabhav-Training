package com.monocept.model;

public class Metro extends Transport {

	private int stations;
	private double ratePerStation = 3;

	public Metro(int routeId, double baseFare, int stations) {
		super(routeId, baseFare);
		this.stations = stations;
	}

	@Override
	public double calculateFare() {

		return baseFare +(stations * ratePerStation);

	}

}
