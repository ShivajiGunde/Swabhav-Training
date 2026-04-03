package com.monocept.test;

import java.util.Scanner;
import com.monocept.model.*;

public class CotrollableSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\nSelect Device:");
            System.out.println("1. Light");
            System.out.println("2. Fan");
            System.out.println("3. TV");
            System.out.println("4. Speakers");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(scanner.nextLine().trim());
            Controllable device = null;

            switch (choice) {
                case 1: device = new Light(); break;
                case 2: device = new Fan(); break;
                case 3: device = new TV(); break;
                case 4: device = new Speakers(); break;
                case 5:
                    running = false;
                    System.out.println("Exiting Smart Home System...");
                    continue;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            boolean deviceRunning = true;

            while (deviceRunning) {

                System.out.println("\n1. Turn ON");
                System.out.println("2. Set Mode");
                System.out.println("3. Turn OFF");
                System.out.println("4. Back");

                int op = Integer.parseInt(scanner.nextLine().trim());

                switch (op) {

                    case 1:
                        device.turnOn();
                        break;

                    case 2:
                        System.out.println("Enter mode:");
                        String mode = scanner.nextLine().trim();
                        device.setMode(mode);
                        break;

                    case 3:
                        device.turnOff();
                        break;

                    case 4:
                        deviceRunning = false;
                        break;

                    default:
                        System.out.println("Invalid option!");
                }
            }
        }

        scanner.close();
    }
}