package com.interfaces.multiple;

public interface Showable {
	
	default void show() {
		System.out.println("Showable");
		
	};

}
