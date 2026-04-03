package com.block.model;

public class Test {
	
	static {
		System.out.println("Static block");
	}
	
	public Test() {
		
		System.out.println("Constructor");
	}
	
	public static void main(String[] args) {
		
		Test obj1 = new Test();
		Test obj2 = new Test();
	}

}
