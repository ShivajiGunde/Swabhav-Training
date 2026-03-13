package test;

import java.util.Random;
import java.util.Scanner;

public class PigDice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		final int targetScore = 20;

		boolean playAgain = true;

		while (playAgain) {
			int totalScore = 0;
			int turn = 1;

			System.out.println("\nLet's Play PIG!");

			while (totalScore < targetScore) {

				int turnScore = 0;
				boolean turnOver = false;

				System.out.println("\nTurn " + turn);

				while (!turnOver) {

					System.out.print("Roll or hold? (r/h): ");
					String choice = scanner.nextLine().toLowerCase();

					if (choice.equals("r")) {
						int die = random.nextInt(6) + 1;
						System.out.println("Die: " + die);

						if (die == 1) {
							turnScore = 0;
							turnOver = true;
							System.out.println("Turn over. No score.");
						} else {
							turnScore += die;
						}

					} else if (choice.equals("h")) {
						totalScore += turnScore;
						turnOver = true;
						System.out.println("Score for turn: " + turnScore);
						System.out.println("Total score: " + totalScore);

					} else {
						System.out.println("Invalid input. Enter 'r' or 'h'.");
					}
				}

				turn++;
			}

			System.out.println("\nYou finished in " + (turn - 1) + " turns!");
			System.out.println("Game over!");

			System.out.print("\nDo you want to play again? (yes/no): ");
			String response = scanner.nextLine().trim().toLowerCase();

			if (!response.equals("yes")) {
				playAgain = false;
				System.out.println("Thanks for playing Pig Dice!");
			}
		}

		scanner.close();
	}
}