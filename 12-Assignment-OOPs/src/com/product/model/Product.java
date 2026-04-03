package com.product.model;

public abstract class Product {

	protected String productId;
	protected String productName;
	protected double basePrice;

	public Product(String productName, double basePrice) {
		this.productId = generateProductId();

		if (productName.isEmpty() || !productName.matches("[a-zA-z]+")) {
			throw new IllegalArgumentException("Product name cannot be empty.");
		}
		this.productName = productName;

		if (basePrice <= 0) {
			throw new IllegalArgumentException("base price cannot be negative");
		}
		this.basePrice = basePrice;
	}

	private String generateProductId() {

		return "Id" + System.currentTimeMillis();
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public abstract void display();
}
