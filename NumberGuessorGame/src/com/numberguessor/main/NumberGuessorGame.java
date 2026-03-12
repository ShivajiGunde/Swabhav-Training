package com.numberguessor.main;

import com.numberguessor.model.GameSetting;
import com.numberguessor.model.NumberGuessor;

public class NumberGuessorGame {

	public static void main(String[] args) {
		
		GameSetting gameSetting = new GameSetting(1, 100, 5);

        NumberGuessor game = new NumberGuessor(gameSetting);

        game.startGame();
	}
}
