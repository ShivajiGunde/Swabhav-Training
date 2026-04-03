package com.monocept.model;

public class PushNotification extends Notification{

	public PushNotification(String recipient, String message) {
		super(recipient, message);
	}

	@Override
	public void send() {

		logNotification();
		
		System.out.println("====PushNotification====");
		System.out.println("Notification recipient "+recipient);
		System.out.println("notification alert: "+message);
	}

}
