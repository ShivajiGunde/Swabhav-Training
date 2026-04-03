package com.product.test;

import java.util.Scanner;

import com.product.model.ProductManager;

public class ProductInventorySystem {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of products");
		int n = scanner.nextInt();
		
		scanner.nextLine();
		
		ProductManager productManager = new ProductManager(n);
		
		productManager.createProducts();
		productManager.displayInventory();
		productManager.closeScanner();
		
		
	}
}
