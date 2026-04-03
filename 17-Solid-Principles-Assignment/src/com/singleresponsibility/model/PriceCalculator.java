package com.singleresponsibility.model;

public class PriceCalculator {

	public double applyDiscount(double price, double discountPercentage) {
		return price - (price * discountPercentage / 100);
	}

	public double applyTax(double price, double taxPercentage) {
		return price + (price * taxPercentage / 100);
	}

	public double calculateFinalPrice(Product product, double discount, double tax) {
		double price = applyDiscount(product.getBasePrice(), discount);
		return applyTax(price, tax);
	}
}
