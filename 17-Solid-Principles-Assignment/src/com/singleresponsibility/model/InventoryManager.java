package com.singleresponsibility.model;

public class InventoryManager {

	private int stock;

	public InventoryManager(int initialStock) {
		this.stock = initialStock;
	}

	public void addStock(int quantity) {
		stock += quantity;
	}

	public void reduceStock(int quantity) {
		if (quantity <= stock) {
			stock -= quantity;
		} else {
			throw new IllegalArgumentException("Not enough stock");
		}
	}

	public int getStock() {
		return stock;
	}
}
