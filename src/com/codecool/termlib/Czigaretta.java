package com.codecool.termlib;

import java.io.IOException;

public class Czigaretta {

	public static Obstacle obstacle = new Obstacle(140, 29);
  
	public static Dino dino = new Dino(15, 30);

	public static void main(String[] args) throws InterruptedException {
		ScreenGrid grid = new ScreenGrid();
		Terminal screen = new Terminal();
		screen.init();

		String[][] output;
		char button;
		while (true) {
			button = Czigaretta.tryToRead();
			if (button == 'q') {
			    break;		
                        }
			output = grid.getGrid();
			grid.init();
			grid.refreshGrid(dino, obstacle);
			screen.clearScreen();
			screen.printMap(output);
			Thread.sleep(100);
			obstacle.modifyPosition();
		}
	}

        private static Character tryToRead() {
	    try {
		if (System.in.available() > 0) {
		    return (char)System.in.read();
		}
	    }
	    catch (IOException e) {
		System.err.println("Error " + e.getMessage());
	    }
	    return 'i';
	}
}
