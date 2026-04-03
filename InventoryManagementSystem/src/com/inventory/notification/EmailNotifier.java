package com.inventory.notification;

public class EmailNotifier implements Notifier {

	@Override
	public void send(String message) {

		System.out.println("[Email] Notification sent: " + message);
	}

}
