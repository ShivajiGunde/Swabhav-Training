package com.order.model;

public abstract class Order implements Comparable<Order> {

	private int orderId;
	private String customerName;
	private double totalAmount;

	public Order(int orderId, String customerName, double totalAmount) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
	}

	public int getOrderId() {

		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getTotalAmount() {
		return totalAmount;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Order))
			return false;
		return this.orderId == ((Order) obj).orderId;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(orderId);
	}

	public abstract String orderType();

	@Override
	public String toString() {
		return "OrderId: " + orderId + ", CustomerName: " + customerName + ", TotalAmount: " + totalAmount + ", Type: "
				+ orderType();
	}

}
