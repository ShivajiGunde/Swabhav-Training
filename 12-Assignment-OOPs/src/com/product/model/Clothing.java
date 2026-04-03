package com.product.model;

public class Clothing extends Product{

	private String size;
	
	public Clothing(String productName, double basePrice,String size) {
		super(productName, basePrice);
		
		if(size.isEmpty() || size.matches("^[S|M|L|XL]$")) {
			throw new IllegalArgumentException("size Cannot be empty or enter valid size");
		}
		this.size = size;
	}
	@Override
	public void display() {
		
		System.out.println("ProductId: "+productId);
		System.out.println("Product Type: Cloths");
		System.out.println("Producy Name: "+productName);
		System.out.println("Base Price: "+basePrice);
		System.out.println("Cloth Size: "+size);		
	}

}
