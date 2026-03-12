package com.numberguessor.model;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessor {

	private long numberToGuess;
	private GameSetting game;

	public NumberGuessor(GameSetting game) {
		this.game = game;
		Random rand = new Random();
		this.numberToGuess = rand.nextInt(game.getMaxRange() - game.getMinRange() + 1) + game.getMinRange();
	}

	public void startGame() {

		Scanner scanner = new Scanner(System.in);

		int attempts = 0;
		boolean isGuessed = false;

		System.out.println("Welcome to the Number Guesser Game!  ");
		System.out.println("Guess a number between " + game.getMinRange() + " and " + game.getMaxRange() + ".");
		System.out.println("You have " + game.getMaxAttempts() + " attempts.");

		while (attempts < game.getMaxAttempts()) {
			System.out.print("Enter your guess: ");
			int guess = 0;

			try {
				guess = scanner.nextInt();

				if (guess < game.getMinRange() || guess > game.getMaxRange()) {
					System.out.println(
							"Please enter a number between " + game.getMinRange() + " and " + game.getMaxRange() + ".");
					continue;
				}

			} catch (InputMismatchException e) {
				System.out.println(" Invalid input! Please enter a valid integer.");
				scanner.next();
				continue;
			}

			attempts++;

			if (guess == numberToGuess) {
				isGuessed = true;
				break;
			} else if (guess < numberToGuess) {
				System.out.println("Too low!");
			} else {
				System.out.println("Too high!");
			}

			System.out.println("Attempts left: " + (game.getMaxAttempts() - attempts));
		}

		if (isGuessed) {
			System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly in " + attempts
					+ " attempts");
		} else {
			System.out.println("Sorry! You used all attempts. The number was: " + numberToGuess);
		}

		scanner.close();
	}

}
