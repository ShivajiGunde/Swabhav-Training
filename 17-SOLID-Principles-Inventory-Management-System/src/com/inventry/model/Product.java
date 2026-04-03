package com.inventry.model;

public class Product {

	private int productId;
	private String prodName;
	private int quantity;
	private int reorderLevel;
	private double price;

	public Product(int productId, String prodName, int quantity, int reorderLevel, double price) {
		super();
		this.productId = productId;
		this.prodName = prodName;
		this.quantity = quantity;
		this.reorderLevel = reorderLevel;
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;

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

	public Integer getProductId() {
		return productId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodName=" + prodName + ", quantity=" + quantity
				+ ", reorderLevel=" + reorderLevel + ", price=" + price + "]";
	}

}
