package com.monocept.model;

import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends Player {

	private Random random;

	public ComputerPlayer(String name, char symbol) {
		super(name, symbol, null);

		random = new Random();
	}

	@Override
	public void makeMove(Board board) {

		int row, col;
		
				System.out.println("Computer is making a move...");

		while (true) {
			row = random.nextInt(3);
			col = random.nextInt(3);

			if (board.isCellEmpty(row, col)) {
				board.updateCell(row, col, symbol);

				System.out.println("Computer played at: " + (row + 1) + "," + (col + 1));
				break;

			}
		}
	}
	

}
