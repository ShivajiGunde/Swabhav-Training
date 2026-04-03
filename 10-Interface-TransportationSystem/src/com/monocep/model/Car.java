package com.monocep.model;

public class Car implements VehicleControl {

	private int currentGear;

	@Override
	public void start() {
		System.out.println("Starting Car with gear " + currentGear);
	}

	@Override
	public void stop() {
		System.out.println("Car stoped ");
	}

	@Override
	public void changeGear(int gear) {
		if (gear < 0 || gear > 6) {

			System.out.println("Invalid Gear");
			return;
		}
		currentGear = gear;
		System.out.println("Car changed to gear " + currentGear);
	}

}
