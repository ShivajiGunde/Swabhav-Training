package com.widening.model;

public class ImplicitExample {
	
	public static void main(String[] args) {
		
		int num = 10;
		double d = num; //int -> double
		
		System.out.println("Integer "+num);
		System.out.println("Widening: "+d);
		
	}

}
