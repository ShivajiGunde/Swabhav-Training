package com.monocept.model;

public class Product {

	private final String productId;
	private double price;
	private int stockQuantity;

	public Product(double price, int stockQuantity) {

	if (price <= 0)
			System.out.println("Price must be greater than 0");

		this.productId = generateProductId();
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	private String generateProductId() {

		return "ProductId" + System.currentTimeMillis();
	}

	public String getProductId() {
		return productId;
	}

	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}
}
