package com.monocept.model;

import java.util.Scanner;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	private Player currentPlayer;

	public Game() {
	}

	public Game(int mode) {

		Scanner scanner = new Scanner(System.in);
		this.board = new Board();

		String name1;
		while (true) {
			System.out.println("Enter the player-1 name(X): ");
			name1 = scanner.nextLine().trim();

			if (!name1.isEmpty()) {
				break;
			} else {
				System.out.println("Name cannot be empty");

			}
		}
		player1 = new HumanPlayer(name1, 'X', scanner);

		if (mode == 1) {
			String name2;
			while (true) {

				System.out.println("Enter Player-2 name (O): ");
				name2 = scanner.nextLine().trim();

				if (!name2.isEmpty()) {
					break;
				} else {
					System.out.println("Name cannot be empty");
				}

			}
			player2 = new HumanPlayer(name2, 'O', scanner);

		} else {

			player2 = new ComputerPlayer("Computer", 'O');
		}

		currentPlayer = player1;
	}

	public void start() {

		while (true) {

			board.display();
			currentPlayer.makeMove(board);

			if (board.checkWinner(currentPlayer.getSymbol())) {
				board.display();
				System.out.println(currentPlayer.getName()+" " + currentPlayer.getSymbol() + " wins!");
				break;

			}

			if (board.isFull()) {
				board.display();
				System.out.println("It's a draw!");
				break;
			}

			switchPlayer();
		}
	}

	private void switchPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}

	}

}
