package com.sudoku.model;

import java.util.Scanner;

public class SudokuGame {

	private SudokuBoard sudokuBoard;
	private Scanner scanner;

	public SudokuGame() {
		this.sudokuBoard = new SudokuBoard();
		this.scanner = new Scanner(System.in);
	}

	public void start() {

		System.out.println("Welcome to Sudoku!");

		System.out.println("Choose Difficulty:");
		System.out.println("1. Easy");
		System.out.println("2. Medium");
		System.out.println("3. Hard");

		int difficulty = scanner.nextInt();

		int toRemove;

		switch (difficulty) {
		case 1:
			toRemove = 20;
			break;

		case 2:
			toRemove = 40;
			break;

		case 3:
			toRemove = 55;
			break;

		default:
			toRemove = 30;
			System.out.println("Invalid choice. Default difficulty selected.");
		}

		SudokuGenerator generator = new SudokuGenerator(sudokuBoard);
		generator.generate(toRemove);

		System.out.println("Sudoku Generated!");

		while (!sudokuBoard.isFull()) {
			sudokuBoard.display();
			makeMove();

		}

		System.out.println("Congratulations! You solved the Sudoku!");
	}

	public void makeMove() {
		try {
			System.out.println("Enter your move:");

			System.out.println("Enter row");
			int r = scanner.nextInt();

			System.out.println("Enter column");
			int c = scanner.nextInt();

			System.out.println("Enter number");
			int n = scanner.nextInt();

			if (isMoveValid(r, c, n)) {
				sudokuBoard.setCell(r, c, n);
			} else {
				System.out.println("Invalid move! Try again.");
			}
		} catch (Exception e) {
			System.out.println("Invalid Input.Enter numbers only");

		}

	}

	public boolean isMoveValid(int r, int c, int n) {

		if (r < 0 || r > 8 || c < 0 || c > 8) {

			System.out.println("Row and column must be between 0 and 8");
			return false;
		}
		if (n < 1 || n > 9) {
			System.out.println("Number must be between 1 and 9.");
			return false;
		}

		return sudokuBoard.isValid(r, c, n);
	}
}