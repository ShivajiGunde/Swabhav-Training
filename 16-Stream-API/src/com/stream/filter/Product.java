package com.stream.filter;

public class Product {

	int id;
	String pName;
	double price;

	Product(int id, String pName, double price) {
		this.id = id;
		this.pName = pName;
		this.price = price;

	}

	@Override
	public String toString() {

		return "Id: " + id + "ProductName: " + pName + "Price: " + price;
	}

	

}
