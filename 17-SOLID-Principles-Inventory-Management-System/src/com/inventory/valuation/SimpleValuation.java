package com.inventory.valuation;

import java.util.List;
import java.util.Map;

import com.inventry.model.Product;

public class SimpleValuation implements ValuationStrategy {

	@Override
	public double calculateValue(Map<Integer, Product> products) {
		double total = 0;
		for (Product p : products.values()) {

			total += p.getQuantity() * p.getPrice();
		}
		return total;

	}

}
