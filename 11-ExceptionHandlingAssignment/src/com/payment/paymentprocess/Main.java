package com.payment.paymentprocess;

public class Main {
	public static void main(String[] args) {
		
		try {
			
		PaymentProcessor p = new PaymentProcessor();
		
		p.processPayment();
		}catch(RuntimeException e) {
			
			e.printStackTrace();
		}
	}

}
