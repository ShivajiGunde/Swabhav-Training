package com.inventry.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.inventory.valuation.ValuationStrategy;
import com.inventry.model.Product;
import com.inventry.notification.Notifier;

public class InventoryService {

	private Map<Integer, Product> products = new HashMap<>();
	private List<Notifier> notifiers;
	private ReorderService reorderService;
	private ValuationStrategy valuationStrategy;

	public InventoryService(ReorderService reorderService, List<Notifier> notifier,
			ValuationStrategy valuationStrategy) {
		super();
		this.reorderService = reorderService;
		this.notifiers = notifier;
		this.valuationStrategy = valuationStrategy;
	}

	public void addProduct(Product product) {

		products.put(product.getProductId(), product);

		System.out.println("Product added: " + product.getProdName());

	}

	public void removeStock(int productId, int qty) {

		Product product = products.get(productId);

		if (product == null) {
			System.out.println("Product not found");
			return;
		}

		if (qty > product.getQuantity()) {
			System.out.println("Requested qty exceeds available stock");
			return;
		}
		product.setQuantity(product.getQuantity() - qty);
		System.out.println(qty + "Stock removed from product \"" + product.getProdName() + "\".");

		// check the reorder
		checkAndReorder(product);

	}

	private void checkAndReorder(Product product) {
		if (product.getQuantity() <= product.getReorderLevel()) {
			reorderService.reorder(product);

			for (Notifier notifier : notifiers) {
				notifier.send("Low stock alert for product: " + product.getProdName());
			}
		}

	}

	public void printInventoryValue() {
		double value = valuationStrategy.calculate(products);
		System.out.printf("Total inventory value: $%.2f\n", value);
	}

	public void showAllProducts() {
		if (products.isEmpty()) {
			System.out.println("No products available.");
			return;
		}

		for (Product product : products.values()) {
			System.out.println(product);
		}
	}
}
