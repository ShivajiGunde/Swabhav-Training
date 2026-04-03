package com.inventory.valuation;

import java.util.List;
import java.util.Map;

import com.inventry.model.Product;

public interface ValuationStrategy {

	double calculateValue(Map<Integer, Product> products);

}
