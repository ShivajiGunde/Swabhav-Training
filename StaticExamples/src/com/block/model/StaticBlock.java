package com.block.model;

public class StaticBlock {
	
	static int num;
	
	static {
		num =100;
		System.out.println("Static block initializes num");
	}
	
	public static void main(String[] args) {
		
		System.out.println("Value of num "+num);
	}

}
