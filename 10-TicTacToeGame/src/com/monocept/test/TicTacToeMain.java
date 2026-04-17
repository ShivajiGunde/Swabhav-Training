package com.monocept.test;

import com.monocept.facade.TicTacToeFacade;

public class TicTacToeMain {
	
	public static void main(String[] args) {
		
		TicTacToeFacade facade = new TicTacToeFacade();
		
		facade.startGame();
		
	}
}
