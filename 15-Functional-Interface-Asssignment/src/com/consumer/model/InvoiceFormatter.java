package com.consumer.model;

import java.util.Arrays;
import java.util.function.Consumer;

public class InvoiceFormatter {
	public static void main(String[] args) {
		
		//Consumer<Invoice> invoice = () -> Arrays.asList(new Invoice("TV", 2, 10000),
			//							new Invoice("Mobile", 5, 50000));Consumer<Invoice> invoice = () -> Arrays.asList(new Invoice("TV", 2, 10000),
		
		
		Consumer<Invoice> printInvoice = invoice -> {
            double total = invoice.quantity * invoice.price;
            System.out.println("Item: " + invoice.itemName +
                    " | Quantity: " + invoice.quantity +
                    " | Total: ₹" + total);
        };

        // Creating 3 invoice objects
        Invoice inv1 = new Invoice("Pen", 2, 10);
        Invoice inv2 = new Invoice("Notebook", 3, 50);
        Invoice inv3 = new Invoice("Pencil", 5, 5);

        // Using the Consumer
        printInvoice.accept(inv1);
        printInvoice.accept(inv2);
        printInvoice.accept(inv3);
		
	}

}
