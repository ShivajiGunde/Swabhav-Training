package com.monocept.model;

public class Speakers implements Controllable {

	@Override
	public void turnOn() {
		System.out.println("Speaker turned ON");
	}

	@Override
	public void turnOff() {
		System.out.println("Speaker turned OFF");

	}

	@Override
	public void setMode(String mode) {
		 if (mode.equalsIgnoreCase("Bass") ||
		            mode.equalsIgnoreCase("Surround") ||
		            mode.equalsIgnoreCase("Party") ||
		            mode.equalsIgnoreCase("Normal")) {

		System.out.println("Speaker mode set to: " + mode);
	}else {
		System.out.println("Invalid mode");
		}
	}

}
