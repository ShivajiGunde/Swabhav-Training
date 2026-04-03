package com.singleresponsibility.model;

public class ProductRenderer {

	public String render(Product product, double finalPrice) {
		
		return "Product: " + product.getName() + "\nDescription: " + product.getDescription() + "\nPrice: $"
				+ finalPrice;
	}
}
