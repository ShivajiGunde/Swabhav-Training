package com.monocept.model;

public class TV implements Controllable {

	@Override
	public void turnOn() {
		System.out.println("TV turned ON");
	}

	@Override
	public void turnOff() {
		System.out.println("TV turned OFF");

	}

	@Override
	public void setMode(String mode) {
		if (mode.equalsIgnoreCase("HD") ||
	            mode.equalsIgnoreCase("FullHD") ||
	            mode.equalsIgnoreCase("4K") ||
	            mode.equalsIgnoreCase("Cinema")) {

		System.out.println("Speaker mode set to: " + mode);
	}
		else {
            System.out.println("Invalid TV mode!");}
	}

}
