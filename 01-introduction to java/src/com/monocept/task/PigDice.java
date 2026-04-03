package com.monocept.task;

import java.util.Random;
import java.util.Scanner;

public class PigDice {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int totalScore = 0;
		final int targetScore = 20;

		System.out.println("Let's Play PIG!");
		System.out.println("Reach 20 points to win.\n");

		for (int turn = 1; totalScore < targetScore; turn++) {

			int turnScore = 0;
			System.out.println("Turn " + turn);

			for (boolean turnOver = false; !turnOver;) {

				System.out.print("Roll or hold? (r/h): ");
				String choice = scanner.nextLine().toLowerCase();

				if (choice.equals("r")) {

					int die = random.nextInt(6) + 1;
					System.out.println("Die: " + die);

					if (die == 1) {
						turnScore = 0;
						turnOver = true;
						System.out.println("Turn over. No score.\n");
					} else {
						turnScore += die;
					}

				} else if (choice.equals("h")) {

					totalScore += turnScore;
					turnOver = true;

					System.out.println("Score for turn: " + turnScore);
					System.out.println("Total score: " + totalScore + "\n");

				} else {
					System.out.println("Invalid input. Enter 'r' or 'h'.");
				}
			}
		}

		System.out.println("You reached 20 points or more");
		scanner.close();
	}

}
