package com.interfaces.multiple;

public interface Printable {
	
	void print();
	
	default void show() {
		System.out.println("Printable method..");
	};

}
