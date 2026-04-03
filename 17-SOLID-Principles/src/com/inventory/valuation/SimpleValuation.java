package com.inventory.valuation;

import java.util.Map;

import com.inventry.model.Product;

public class SimpleValuation implements ValuationStrategy{

	@Override
	public double calculate(Map<Integer, Product> inventory) {
		
		double total = 0;
		
		for(Product p : inventory.values()) {
			total += p.getPrice() * p.getQuantity(); 
		}
		return total;
	}

}
