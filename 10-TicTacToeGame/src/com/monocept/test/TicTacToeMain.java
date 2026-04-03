package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.Game;

public class TicTacToeMain {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String replay;
		do {
			System.out.println("\nSelect Game mode");
			System.out.println("1.Human vs human");
			System.out.println("2.Human vs Computer");
			
			int choice = scanner.nextInt();
			
			scanner.nextLine();
			
		Game game = new Game(choice);
		
		game.start();	
		
		System.out.println("Do you want to play Again(yes/no)");
		 replay = scanner.next();
		
	}while(replay.equalsIgnoreCase("yes"));
			
		System.out.println("Thanks for playing");
		scanner.close();
	}
}
