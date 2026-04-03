package com.classs.model;

public class StaticMain {

	public static void main(String[] args) {
		
		Outer.Inner obj = new Outer.Inner();
		
		obj.display(); 
		
		//no outer object needed 
	}
}
