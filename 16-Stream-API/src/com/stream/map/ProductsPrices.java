package com.stream.map;

public class ProductsPrices {
	protected String name;
	protected double price;

	@Override
	public String toString() {
		return "ProductsPricess [name=" + name + ", price=" + price + "]";
	}

	public ProductsPrices(String name, double price) {
		this.name = name;
		this.price = price;
	}

}
