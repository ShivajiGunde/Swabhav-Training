package com.monocept.model;

public class SmsNotification extends Notification {

	public SmsNotification(String recipient, String message) {
		super(recipient, message);
	}

	@Override
	public void send() {
		logNotification();
		
		System.out.println("====Sms====");
		System.out.println("Send Sms to: " + recipient);
		System.out.println("Message :" + message);

	}

}
