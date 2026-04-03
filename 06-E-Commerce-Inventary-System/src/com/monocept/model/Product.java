package com.monocept.model;

public class Product {

	private final long productId;
	private String productName;
	private double price;
	private int stockQuantity;
	private boolean discontinued;

	private static long counter = 100;

	
	public Product(String productName, double price, int stockQuantity) {

		validatePrice(price);
		validateStock(stockQuantity);

		this.productId = generateProductId();
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.discontinued = false;
	}

	

	private long generateProductId() {

		return ++counter;
	}

	public long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	private void validateStock(int quantity) {
		if (quantity < 0) {

			System.out.println("Stock cannot be negative");
		}
	}

	public void discontinueProduct() {
		this.discontinued = true;
	}

	// updating price
	public void updatePrice(double newPrice, boolean isAdmin) {
		if (!isAdmin) {

			System.out.println("Only admin can update price");
		}
		validatePrice(newPrice);
		this.price = newPrice;
	}

	public void increaseStock(int quantity) {
		if (discontinued) {
			
			System.out.println("Cannot modify stock of discontinued product");
		}

		validateStock(quantity);
		this.stockQuantity += quantity;
	}

	public void reduceStock(int quantity) {
		if (discontinued) {

			System.out.println("Cannot modify stock of discontinued product");
		}
		
		validateStock(quantity);
		if (quantity > stockQuantity) {
		
			System.out.println("Insufficient stock");
		}
		this.stockQuantity -= quantity;
	}

	
	private void validatePrice(double price) {
		if (price < 0) {
			
			System.out.println("Price cannot be negative");
		}
	}

}
