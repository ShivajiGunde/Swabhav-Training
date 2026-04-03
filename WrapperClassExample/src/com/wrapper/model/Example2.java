package com.wrapper.model;

public class Example2 {
	public static void main(String[] args) {
		
		int a = 10;
		
		Integer obj = a; //Autoboxing (primitive -> object)
		
		int b = obj; //unboxing (object -> primitive)
		
		System.out.println("Integer Object: "+obj);
		System.out.println("Primitive "+b);
		
		
		
	}

}
