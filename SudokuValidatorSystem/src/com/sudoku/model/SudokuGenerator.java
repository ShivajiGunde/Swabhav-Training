package com.sudoku.model;

import java.util.Random;

public class SudokuGenerator {

	private SudokuBoard sudokuBoard;
	private Random random = new Random();

	public SudokuGenerator(SudokuBoard sudokuBoard) {

		this.sudokuBoard = sudokuBoard;

	}

	public void generate(int cellsToRemove) {
		fillBoard();
		removeCells(cellsToRemove);
	}

	private boolean fillBoard() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (sudokuBoard.getCell(row, col) == 0) {
					int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
					shuffle(nums);
					for (int num : nums) {
						if (sudokuBoard.isValid(row, col, num)) {
							sudokuBoard.setCell(row, col, num);
							if (fillBoard())
								return true;
							sudokuBoard.setCell(row, col, 0);
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private void removeCells(int count) {
		while (count > 0) {
			int r = random.nextInt(9);
			int c = random.nextInt(9);
			if (sudokuBoard.getCell(r, c) != 0) {
				sudokuBoard.setCell(r, c, 0);
				count--;
			}
		}
	}

	private void shuffle(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}
}
