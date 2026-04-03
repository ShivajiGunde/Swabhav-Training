package com.inventory.valuation;
import java.util.Map;

import com.inventry.model.Product;

public interface ValuationStrategy {
	double calculate(Map<Integer,Product> inventory);

}
