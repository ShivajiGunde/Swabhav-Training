package com.inventry.notification;

import com.inventry.model.Product;

public class EmailNotifier implements Notifier {

	@Override
	public void send(String message) {
		System.out.println("[Email] Notification sent:" + message);
	}

}
