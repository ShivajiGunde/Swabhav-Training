package com.wrapper.model;

public class Example1 {
	
	public static void main(String[] args) {
		
		int a = 10;         //primitive
		Integer b = Integer.valueOf(a);// boxing wrpper object
		
		System.out.println("Primitive: "+a);
		System.out.println("Wrapper Object: "+b);
		
		
	}

}
