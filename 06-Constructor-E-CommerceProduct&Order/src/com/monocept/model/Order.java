package com.monocept.model;

public class Order {

    private String orderId;
    private Product product;
    private int quantity;
    protected double totalAmount;
    

    public Order(Product product, int quantity) {

        if (product == null)
            System.out.println("Product cannot be null");

        if (quantity <= 0)
            System.out.println("Quantity must be greater than 0");

        this.setOrderId(generateOrderId());
        this.setProduct(product);
        this.setQuantity(quantity);

        this.totalAmount = calculateTotal();
    }

    protected double calculateTotal() {
        return getProduct().getPrice() * getQuantity();
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    
    public String generateOrderId() {
    	
    	return "OrderId"+System.currentTimeMillis();
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
