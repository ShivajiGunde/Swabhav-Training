package com.monocept.mode;

public interface PaymentGateway {
	void pay(double amount);
	void refund(double amount);

}
