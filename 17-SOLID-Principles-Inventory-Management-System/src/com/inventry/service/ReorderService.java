package com.inventry.service;

import java.util.List;

import com.inventry.model.Product;
import com.inventry.notification.Notifier;

public class ReorderService {

	private List<Notifier> notifiers;

	public ReorderService(List<Notifier> notifiers) {
		this.notifiers = notifiers;
	}

	public void checkAndReorder(Product product) {

		if (product.getQuantity() <= product.getReorderLevel()) {

			int reorderQty = 50; // reorder quantity

			product.setQuantity(product.getQuantity() + reorderQty);

			System.out.println("Reorder placed for " + reorderQty + " ProductName " + product.getProdName());

			String message = "Low stock alert for product: " + product.getProdName();
			for (Notifier notifier : notifiers) {
				notifier.send(message);
			}

		}

	}

}
