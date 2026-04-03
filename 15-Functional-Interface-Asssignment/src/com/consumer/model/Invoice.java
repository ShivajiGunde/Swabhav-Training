package com.consumer.model;

public class Invoice {
	
	String itemName;
	int quantity;
	double price;
	
	Invoice(String itemName,int quantity,double price){
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

}
