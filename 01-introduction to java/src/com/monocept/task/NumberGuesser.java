package com.monocept.task;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int randomNumber = random.nextInt(100) + 1;
		int attempts = 3;
		boolean isGuessed = false;

		System.out.println("Guess a number between 1 and 100");
		System.out.println("You have only " + attempts + " attempts.");

		for (int i = 1; i <= attempts; i++) {

			System.out.println("Enter your Guess: ");
			int guess = scanner.nextInt();

			if (guess < randomNumber) {
				System.out.println("Too low,try again");
			} else if (guess > randomNumber) {

				System.out.println("Too high, try again");
			} else {

				System.out.println("Correct! You guessed in " + attempts + " attempts.");
			   isGuessed = true;
			   break;
			}

		}
		if (!isGuessed) {
            System.out.println("Game Over! The correct number was " + randomNumber);
        }
		scanner.close();

	}

}
