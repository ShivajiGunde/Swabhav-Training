package com.inventry.notification;

public class SMSNotifier implements Notifier {

	@Override
	public void send(String message) {
		System.out.println("[SMS] Notification sent: " + message);
	}

}
