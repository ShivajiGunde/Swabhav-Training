package com.inventry.model;

public class Product {

	private int productId;
	private String prodName;
	private int quantity;
	private int reorderLevel;
	private double price;

	public Product(int productId, String prodName, int quantity, int reorderLevel, double price) {

		if (productId < 0) {
			throw new IllegalArgumentException("product Id cannot be negative");

		}

		this.productId = productId;

		if (prodName == null || !prodName.matches("^[A-Za-z ]{2,50}$")) {
			throw new IllegalArgumentException("Invalid product name Only letters allowed.");
		}
		this.prodName = prodName;

		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}

		this.quantity = quantity;

		if (reorderLevel < 0) {
			throw new IllegalArgumentException("Reorder level cannot be negative");
		}
		this.reorderLevel = reorderLevel;

		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public String getProdName() {
		return prodName;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodName=" + prodName + ", quantity=" + quantity
				+ ", reorderLevel=" + reorderLevel + ", price=" + price + "]";
	}

}
