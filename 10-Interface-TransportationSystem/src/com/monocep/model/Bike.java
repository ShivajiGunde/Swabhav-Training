package com.monocep.model;

public class Bike implements VehicleControl {

	private int currentGear;

	@Override
	public void start() {
		System.out.println("Starting Bike with gear " + currentGear);
	}

	@Override
	public void stop() {
		System.out.println("Stoped Bike");
	}

	@Override
	public void changeGear(int gear) {
		if (gear < 0 || gear > 5) {
			System.out.println("Invalid gear");
			return;
		}
		currentGear = gear;
        System.out.println("Bike changed to gear " + currentGear);
	}

}
