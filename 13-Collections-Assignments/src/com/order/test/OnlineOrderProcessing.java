package com.order.test;

import java.util.List;
import java.util.Scanner;

import com.order.model.Order;
import com.order.model.OrderManager;
import com.order.model.PriorityOrder;
import com.order.model.RegularOrder;

public class OnlineOrderProcessing {

	public static void main(String[] args) {
		OrderManager manager = new OrderManager();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n=== Online Store Menu ===");
			System.out.println("1. Add Regular Order");
			System.out.println("2. Add Priority Order");
			System.out.println("3. Display All Orders");
			System.out.println("4. Sort Orders by ID");
			System.out.println("5. Sort Orders by Amount");
			System.out.println("6. Dispatch Orders");
			System.out.println("7. Remove Order");
			System.out.println("8. Get Orders by Customer");
			System.out.println("9. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter ID: ");
				int id1 = sc.nextInt();
				sc.nextLine();
				System.out.print("Customer Name: ");
				String customer1 = sc.nextLine();
				System.out.print("Total Amount: ");
				double amount1 = sc.nextDouble();
				sc.nextLine();
				manager.addOrder(new RegularOrder(id1, customer1, amount1));
				break;

			case 2:
				System.out.print("Enter ID: ");
				int id2 = sc.nextInt();
				sc.nextLine();
				System.out.print("Customer Name: ");
				String customer2 = sc.nextLine();
				System.out.print("Total Amount: ");
				double amount2 = sc.nextDouble();
				sc.nextLine();
				System.out.print("Priority Level: ");
				int level = sc.nextInt();
				sc.nextLine();
				manager.addOrder(new PriorityOrder(id2, customer2, amount2, level));
				break;

			case 3:
				manager.displayAllOrders();
				break;

			case 4:
				List<Order> byId = manager.sortById();
				byId.forEach(System.out::println);
				break;

			case 5:
				List<Order> byAmount = manager.sortByAmount();
				byAmount.forEach(System.out::println);
				break;

			case 6:
				manager.processDispatch();
				break;

			case 7:
				System.out.print("Enter Order ID to remove: ");
				int remId = sc.nextInt();
				sc.nextLine();
				manager.removeOrder(remId);
				break;

			case 8:
				System.out.print("Enter Customer Name: ");
				String cust = sc.nextLine();
				List<Order> custOrders = manager.getOrdersByCustomer(cust);
				if (custOrders.isEmpty())
					System.out.println("No orders found.");
				else
					custOrders.forEach(System.out::println);
				break;

			case 9:
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
