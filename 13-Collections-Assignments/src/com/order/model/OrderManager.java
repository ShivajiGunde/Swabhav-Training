package com.order.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class OrderManager {

	private Set<Order> orderSet = new HashSet<>();
	private Queue<Order> dispatchQueue = new LinkedList<>();
	private Map<String, List<Order>> customerOrders = new HashMap<>();

	// Add order
	public void addOrder(Order order) {
		if (orderSet.add(order)) {
			System.out.println("Order added: " + order);
			dispatchQueue.offer(order);

			List<Order> list = customerOrders.get(order.getCustomerName());
			if (list == null) {
				list = new ArrayList<>();
				customerOrders.put(order.getCustomerName(), list);
			}
			list.add(order);

		} else {
			System.out.println("Duplicate order! ID already exists.");
		}
	}

	// Process dispatch queue
	public void processDispatch() {
		while (!dispatchQueue.isEmpty()) {
			Order o = dispatchQueue.poll();
			System.out.println("Dispatching order: " + o);
		}
	}

	// Remove cancelled/invalid orders
	public void removeOrder(int orderId) {
		Iterator<Order> it = orderSet.iterator();
		while (it.hasNext()) {
			Order o = it.next();
			if (o.getOrderId() == orderId) {
				it.remove();
				dispatchQueue.remove(o);

				List<Order> list = customerOrders.get(o.getCustomerName());
				if (list != null) {
					list.remove(o);
				}

				System.out.println("Removed order: " + o);
			}
		}
	}

	// Display all orders
	public void displayAllOrders() {
		for (Order o : orderSet) {
			System.out.println(o);
		}
	}

	public List<Order> sortById() {
		List<Order> list = new ArrayList<>(orderSet);

		Collections.sort(list, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				return Integer.compare(o1.getOrderId(), o2.getOrderId());
			}
		});

		return list;
	}

	public List<Order> sortByAmount() {
		List<Order> list = new ArrayList<>(orderSet);

		Collections.sort(list, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				return Double.compare(o1.getTotalAmount(), o2.getTotalAmount());
			}
		});

		return list;
	}

	// Get orders for a customer
	public List<Order> getOrdersByCustomer(String customer) {
		List<Order> list = customerOrders.get(customer);
		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}
}