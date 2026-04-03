package com.inventry.notification;

import com.inventry.model.Product;

public class SMSNotifier implements Notifier {

	@Override
	public void send(String message) {
		System.out.println("[SMS] notification Sent:" + message);
	}

}
