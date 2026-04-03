package com.monocept.model;

public class Fan implements Controllable {

	@Override
	public void turnOn() {

		System.out.println("Fan Turned ON");
	}

	@Override
	public void turnOff() {
		System.out.println("Fan Turned OFF");
	}

	@Override
	public void setMode(String mode) {
		if (mode.equalsIgnoreCase("Low") ||
	            mode.equalsIgnoreCase("Medium") ||
	            mode.equalsIgnoreCase("High")){

		System.out.println("Fan mode set to: " + mode);
	}
		else {
			System.out.println("Invalid mode");
			}
		}

}
