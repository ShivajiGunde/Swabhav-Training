package com.singleresponsibility.model;

public class Product {
	private String name;
	private String description;
	private double basePrice;

	public Product(String name, String description, double basePrice) {
		this.name = name;
		this.description = description;
		this.basePrice = basePrice;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getBasePrice() {
		return basePrice;
	}
}
