package com.interfaces.defaultmethod;

public interface Vehicle {
	
	default void start() {
		System.out.println("Stating...");
	}

}
