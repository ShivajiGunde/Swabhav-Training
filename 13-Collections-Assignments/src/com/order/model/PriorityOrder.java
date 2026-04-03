package com.order.model;

public class PriorityOrder extends Order{
	
	   private int priorityLevel;

	    public PriorityOrder(int orderId, String customerName, double totalAmount, int priorityLevel) {
	        super(orderId, customerName, totalAmount);
	        this.priorityLevel = priorityLevel;
	    }

	    public int getPriorityLevel() {
	        return priorityLevel;
	    }

	    @Override
	    public String orderType() {
	        return "Priority";
	    }

	    @Override
	    public int compareTo(Order o) {
	        if (o instanceof PriorityOrder) {
	            PriorityOrder p = (PriorityOrder) o;
	            return Integer.compare(p.priorityLevel, this.priorityLevel); // higher first
	        }
	        return -1; 
	    }

	    @Override
	    public String toString() {
	        return super.toString() + " PriorityLevel: " + priorityLevel;
	    }
	}



