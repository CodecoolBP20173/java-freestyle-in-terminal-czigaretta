package com.codecool.termlib;

import java.io.IOException;

public class Czigaretta {

	public static Obstacle obstacle = new Obstacle(140, 30);
  
	public static Dino dino = new Dino(10, 30);

	public static void main(String[] args) throws InterruptedException {
		ScreenGrid grid = new ScreenGrid();
		Terminal screen = new Terminal();
		screen.init();

		String[][] output;
		char button;
		boolean jumping = false;
		while (grid.refreshGrid(dino, obstacle)) {
			button = Czigaretta.tryToRead();
			if (jumping) {
		            jumping = dino.jump();
   			} else {
                            if (button == ' ') {
			       jumping = dino.jump();
			    }	
			}
			if (button == 'q') {
          System.out.print("\033[?25h");	
			    break;		
          }
			output = grid.getGrid();
			grid.init();
			grid.refreshGrid(dino, obstacle);
			screen.clearScreen();
			screen.printMap(output);
			Thread.sleep(30);
			obstacle.modifyPosition();
		}
		screen.gameOver();
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
