package com.monocept.model;

public class EmailNotification extends Notification {

	public EmailNotification(String recipient, String message) {
		super(recipient, message);
	}

	@Override
	public void send() {
		
		System.out.println("====Email====");
		System.out.println("Send mail to:" + recipient);
		System.out.println("mail  message: " + message);
	}

}
