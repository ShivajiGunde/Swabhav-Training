package com.monocept.model;

public class Division {
	
	public static int div(int a,int b) {
		
		if(b == 0) {
			System.out.println("cannot divided by 0");
		}
		
		return a/b;
	}

}
