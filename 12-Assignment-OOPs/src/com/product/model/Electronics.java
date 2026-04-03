package com.product.model;

public class Electronics extends Product{
	
	private int warrantyMonth;

	public Electronics(String productName, double basePrice,int warrantyMonth) {
		super(productName, basePrice);
		
		if(warrantyMonth <= 0) {
			
			throw new IllegalArgumentException("Warranty month cannot be negative");
		}
		this.warrantyMonth = warrantyMonth;
	}

	@Override
	public void display() {
		System.out.println("ProductId: "+productId);
		System.out.println("Product Type: Electronics");
		System.out.println("Producy Name: "+productName);
		System.out.println("Base Price: "+basePrice);
		System.out.println("Warranty Months: "+warrantyMonth);
		
	}

}
