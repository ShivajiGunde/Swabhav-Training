package com.inventry.service;

import java.util.Scanner;

import com.inventry.model.Product;

public class ReorderService {

	public void reorder(Product product) {
		int currentStock = product.getQuantity();

		if (currentStock <= product.getReorderLevel()) {

			int reorderQuantity = 50;

			product.setQuantity(currentStock + reorderQuantity);

			System.out.println("Reorder placed for " + reorderQuantity + "ProductName " + product.getProdName() + " ");
		}
	}

}
