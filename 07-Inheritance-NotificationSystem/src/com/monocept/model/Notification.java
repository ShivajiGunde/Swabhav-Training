package com.monocept.model;

public class Notification {
	
	protected String recipient;
	protected String message;
	public Notification(String recipient, String message) {
		super();
		this.recipient = recipient;
		this.message = message;
	}
	
	public void send() {
		
		System.out.println("Sending Notification...");
	}
	
	public void logNotification() {
		
		System.out.println("Logging notification : "+recipient);
	}
	

}
