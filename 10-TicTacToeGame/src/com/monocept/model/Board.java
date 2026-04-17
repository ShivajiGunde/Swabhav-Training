package com.monocept.model;

public class Board {

	private char[][] grid;

	public Board() {
		super();
		this.grid = new char[3][3];
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = ' ';
			}

		}

	}

	public void display() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(grid[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public boolean isCellEmpty(int row, int col) {

		return grid[row][col] == ' ';

	}

	public boolean updateCell(int row, int col, char symbol) {
		if (isCellEmpty(row, col)) {

			grid[row][col] = symbol;

			return true;
		}
		return false;

	}

	public boolean isFull() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == ' ') {

					return false;
				}
			}

		}
		return true;

	}

	public boolean checkWinner(char symbol) {

		for (int i = 0; i < 3; i++) {
			if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) {
				return true;
			}
		}

		if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) {
			return true;
		}

		if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
			return true;
		}

		return false;
	}

}
