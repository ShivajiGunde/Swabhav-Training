package com.inventory.valuation;

import java.util.List;
import java.util.Map;

import com.inventory.model.Product;

public interface ValuationStrategy {

	double calculateValue(Map<Integer, Product> products);

}
