package com.monocept.model;

import java.util.Scanner;

public abstract class Player {

	protected String name;
	protected char symbol;
	protected Scanner scanner;

	public Player(String name, char symbol, Scanner scanner) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.scanner = scanner;

	}

	public String getName() {
		return name;
	}

	public char getSymbol() {

		return symbol;
	}

	public abstract void makeMove(Board board);

}
