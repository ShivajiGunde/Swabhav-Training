package com.interfaces.multiple;

public class Test implements Showable, Printable {


	@Override
	public void show() {
		
		Showable.super.show();
		System.out.println("Showing...");
		Printable.super.show();

	}

	@Override
	public void print() {

		System.out.println("Printing...");
	}

}
