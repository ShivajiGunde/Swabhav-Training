package com.monocept.model;

import java.util.Scanner;

public class HumanPlayer extends Player{

	public HumanPlayer(String name, char symbol, Scanner scanner) {
		super(name, symbol, scanner);
	}

	@Override
	public void makeMove(Board board) {
			int cell,row,col;

			while (true) {
				try {
					
					 System.out.println(name + " (" + symbol + ") - Enter a cell number (1-9): ");
			             cell = scanner.nextInt();

			            if (cell < 1 || cell > 9) {
			                System.out.println("Invalid input! Enter a number between 1 and 9.");
			                continue;
			            }

			            // Convert 1-9 to row/col
			             row = (cell - 1) / 3;
			             col = (cell - 1) % 3;
			            

					if (board.updateCell(row, col, symbol)) {
						break;
					} else {
						System.out.println("Invalid move. Try again.");
					}

				} catch (Exception e) {
					System.out.println("Invalid input! Enter numbers only.");
					scanner.nextLine();
				}
			}

	}

}
