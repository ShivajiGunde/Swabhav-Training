package com.monocep.model;

public class Truck implements VehicleControl {

	private int currentGear;

	@Override
	public void start() {
		System.out.println("Starting Truck with gear " + currentGear);

	}

	@Override
	public void stop() {
		System.out.println("Truck stopped ");
	}

	@Override
	public void changeGear(int gear) {
		if(gear < 0 || gear > 8) {
			System.out.println("Invalid gear for truck ");
			return;
		}
		currentGear = gear;
        System.out.println("Truck changed to gear " + currentGear);
	}

}
