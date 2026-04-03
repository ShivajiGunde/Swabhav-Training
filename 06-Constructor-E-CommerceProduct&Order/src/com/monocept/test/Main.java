package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.DiscountedOrder;
import com.monocept.model.Order;
import com.monocept.model.Product;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        

            System.out.println("Enter Product Price:");
            double price = scanner.nextDouble();

            System.out.println("Enter Stock Quantity:");
            int stock = scanner.nextInt();
            scanner.nextLine(); 

            Product product = new Product(price, stock);
            System.out.println("Product created successfully");

            System.out.println("Select Order Type:");
            System.out.println("1. Normal Order");
            System.out.println("2. Discounted Order");

            int choice = scanner.nextInt();

            if (choice == 1) {
                             
                System.out.println("Enter Quantity:");
                int quantity = scanner.nextInt();

                Order order = new Order(product, quantity);
                System.out.println("\n Order created successfully:");
                
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Product ID: " + order.getProduct().getProductId());
                System.out.println("Quantity: " + order.getQuantity());
                System.out.println("Total Amount: " + order.getTotalAmount());
                
            } 
            else if (choice == 2) {
                
                System.out.println("Enter Quantity:");
                int quantity = scanner.nextInt();

                System.out.println("Enter Discount Percentage:");
                double discount = scanner.nextDouble();

                DiscountedOrder discountedOrder = 
                    new DiscountedOrder(product, quantity, discount);

                System.out.println("\nDiscounted Order created successfully:");
                System.out.println("Order ID: " + discountedOrder.getOrderId());
                System.out.println("Product ID: " + discountedOrder.getProduct().getProductId());
                System.out.println("Quantity: " + discountedOrder.getQuantity());
                System.out.println("Discount: " + discountedOrder.getDiscountPercentage() + "%");
                System.out.println("Discounted Total: " + discountedOrder.getTotalAmount());

            } 
            else {
                System.out.println("Invalid choice!");
            }

            scanner.close();
        }

		
	}
    

