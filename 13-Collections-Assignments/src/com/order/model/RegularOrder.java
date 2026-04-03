package com.order.model;

public class RegularOrder extends Order{



	    public RegularOrder(int orderId, String customerName, double totalAmount) {
	        super(orderId, customerName, totalAmount);
	    }

	    @Override
	    public int compareTo(Order o) {
	        return Integer.compare(this.getOrderId(), o.getOrderId());
	    }

	    @Override
	    public String orderType() {
	        return "Regular";
	    }
	}


