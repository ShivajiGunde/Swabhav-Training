package com.function.model;

import java.util.function.Function;

public class TempratureConverter {
	
	public static void main(String[] args) {
		
		
		
		Function<Double, Double> cTof = c -> (c * 9/5) + 32;
				
				double temp1 = 0.0 ;
				double temp2 = 20.0;
				double temp3 = 37.0;
				
				System.out.println(temp1+ "°C -> "+cTof.apply(temp1)+"°F");
				System.out.println(temp2+ "°C -> "+cTof.apply(temp2)+"°F");
				System.out.println(temp3+ "°C -> "+cTof.apply(temp3)+"°F");

				
		}

}
