package com.monocept.model;

public class Light implements Controllable {

	@Override
	public void turnOn() {
		System.out.println("Light turned ON");
	}

	@Override
	public void turnOff() {
		System.out.println("Light turned OFF");
	}

	@Override
	public void setMode(String mode) {
		if (mode.equalsIgnoreCase("Dim") ||
	            mode.equalsIgnoreCase("Bright") ||
	            mode.equalsIgnoreCase("Night")) {


		System.out.println("Light mode set to: " + mode);
	}else {
		
	System.out.println("Invalid light mode");}
	}

}
