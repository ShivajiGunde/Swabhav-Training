package com.singleresponsibility.model;

public class ProductService {
	
	    private PriceCalculator calculator;
	    private InventoryManager inventory;
	    private ProductRenderer renderer;

	    public ProductService(PriceCalculator calculator, InventoryManager inventory, ProductRenderer renderer) {
	        this.calculator = calculator;
	        this.inventory = inventory;
	        this.renderer = renderer;
	    }

	    public double getFinalPrice(Product product, double discount, double tax) {
	        return calculator.calculateFinalPrice(product, discount, tax);
	    }

	    public String getProductDetails(Product product, double finalPrice) {
	        return renderer.render(product, finalPrice);
	    }

	    public void purchaseProduct(int quantity) {
	        inventory.reduceStock(quantity);
	    }

	    public int getRemainingStock() {
	        return inventory.getStock();
	    }
	}


