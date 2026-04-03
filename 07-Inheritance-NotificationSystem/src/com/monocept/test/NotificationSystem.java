package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.EmailNotification;
import com.monocept.model.Notification;
import com.monocept.model.PushNotification;
import com.monocept.model.SmsNotification;

public class NotificationSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of notifications");
		int n = scanner.nextInt();

		scanner.nextLine();

		Notification[] notification = new Notification[n];

		int i = 0;
		while (i < n) {

			System.out.println("Notification Details " + (i + 1));

			System.out.println("Enter type Notification");

			System.out.println("1.Email");
			System.out.println("2.Sms");
			System.out.println("3.PushNotification");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter the email");
				String email = scanner.nextLine();

				if (!email.contains("@") || !email.contains(".") || email.trim().isEmpty()) {
					System.out.println("Invalid email. Try again");
					continue;
				}
				System.out.println("Enter the message");
				String message = scanner.nextLine();

				if (message.trim().isEmpty()) {
					System.out.println("message cannot be empty");
					continue;
				}
				notification[i] = new EmailNotification(email, message);
				break;
			case 2:

				System.out.println("Enter the recipient number");
				String mobile = scanner.nextLine();

				if (!mobile.matches("\\d{10}")) {
					System.out.println("Invalid mobile number.mobNo must 10 digits");
					continue;
				}

				System.out.println("Enter the message");
				String smsMessage = scanner.nextLine();

				if (smsMessage.trim().isEmpty()) {
					System.out.println("message cannot be empty");
					continue;
				}

				notification[i] = new SmsNotification(mobile, smsMessage);
				break;
			case 3:
				System.out.println("Enter the recipient");
				String recipient = scanner.nextLine();

				if (recipient.trim().isEmpty()) {
					System.out.println("recipient cannot be empty");
					continue;
				}
				System.out.println("Enter the message");
				String pushMessage = scanner.nextLine();

				if (pushMessage.trim().isEmpty()) {
					System.out.println("message cannot be empty");
					continue;
				}
				notification[i] = new PushNotification(recipient, pushMessage);
				break;

			default:
				System.out.println("Invalid choice");
				continue;
			}
			i++;
		}

		for (Notification notific : notification) {
			if (notific != null) {
				notific.send();
			}

		}
		scanner.close();

	}
}
