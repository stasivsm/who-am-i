package com.eleks.academy.whoami;

import java.util.List;

import com.eleks.academy.whoami.core.Game;
import com.eleks.academy.whoami.core.impl.RandomGame;
import com.eleks.academy.whoami.core.impl.RandomPlayer;
import com.eleks.academy.whoami.core.impl.SillyPlayer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Game Init!");
		
		List<String> characters = List.of("Batman", "Superman", "Hulk");
		List<String> questions = List.of("Am i a human?", "Am i a character from a movie?", "Am I a boy?", "Am I blond?",
				"Is my hair color black?", "Am I very old?", "Do I fly?", "Is kryptonite my weakness?");
		List<String> guessess = List.of("Batman", "Superman", "Hulk");
		
		Game game = new RandomGame(characters);
		game.addPlayer(new SillyPlayer("Test1", questions, guessess));
		game.addPlayer(new SillyPlayer("Test2", questions, guessess));
		game.assignCharacters();
		game.initGame();
		while (!game.isFinished()) {
			boolean turnResult = game.makeTurn();
			while (turnResult) {
				turnResult = game.makeTurn();
			}
			game.changeTurn();
		}
		
		
		
	}
	

}
