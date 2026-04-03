package com.Supplier.model;

import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCityProvider {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Supplier<String> defaultCity = () -> "Pune";
		
		System.out.println("Enter city name");
		String city = scanner.nextLine();
		
		if(city.isEmpty()) {
			
			System.out.println("Default City: "+defaultCity.get());
		}
	}

}
