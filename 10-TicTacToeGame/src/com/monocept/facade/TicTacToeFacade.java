package com.monocept.facade;

import java.util.Scanner;

import com.monocept.model.Game;

public class TicTacToeFacade {

	private Scanner scanner = new Scanner(System.in);

	public void startGame() {

		String replay;

		do {
			int choice;

			while (true) {
				System.out.println("\nSelect Game Mode:");
				System.out.println("1. Human vs Human");
				System.out.println("2. Human vs Computer");

				try {
					choice = scanner.nextInt();
					scanner.nextLine();

					if (choice == 1 || choice == 2) {
						break;
					} else {
						System.out.println("Invalid choice! Try again.");
					}

				} catch (Exception e) {
					System.out.println("Enter numbers only!");
					scanner.nextLine();
				}
			}

			Game game = new Game(choice);
			game.start();

			System.out.println("Play again? (yes/no): ");
			replay = scanner.next();

		} while (replay.equalsIgnoreCase("yes"));

		System.out.println("Thanks for playing.");
		scanner.close();
	}
}