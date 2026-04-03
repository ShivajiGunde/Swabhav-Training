package com.flights.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FlightMain {
	
	public static void main(String[] args) {
		
		ArrayList<Flight> list = new ArrayList<Flight>();
		
		list.add(new Flight("AirIndia",4000.00));
		list.add(new Flight("Emirates",10000.00));
		list.add(new Flight("Indigo",5000.00));
		list.add(new Flight("JetWay",6000.00));
		
		list.sort((f1,f2) -> Double.compare(f2.fare,f1.fare)); 
		
		for (Flight f : list) {
			
            System.out.println(f);
        }

	}

}
