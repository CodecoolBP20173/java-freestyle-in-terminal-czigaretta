package com.codecool.termlib;

import java.io.IOException;

public class Czigaretta {

	public static Obstacle obstacle = new Obstacle(140, 30);
  
	public static Dino dino = new Dino(10, 30);

	public static void main(String[] args) throws InterruptedException {
	    ScreenGrid grid = new ScreenGrid();
	    Terminal screen = new Terminal();
	    char button = 'i';
	    boolean progress;	
	    screen.menu();
            while (button != 's') {
		screen.raw(true);
                button = Czigaretta.tryToRead();
	    }

	    progress = startGame(grid, screen);
	    while (progress != false) {
		screen.gameOver();
		screen.raw(true);
		    button = Czigaretta.tryToRead(); 
		    if (button == 'r') {	
			grid = new ScreenGrid();
			obstacle = new Obstacle(140, 30);
			dino = new Dino(10, 30);
		        startGame(grid, screen);
		    }
		    if (button == 'q') {
		        break;
		    }
	    }   	
	    screen.raw(false);
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

        private static boolean startGame(ScreenGrid grid, Terminal screen) throws InterruptedException {
	    screen.init();
		String[][] output;
		char button;
		boolean jumping = false;
		grid.score = 0;
		while (grid.checkForDeath(dino, obstacle)) {
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
			    return true;		
          		}
			output = grid.getGrid();
			grid.init();
			grid.refreshGrid(dino, obstacle);
			screen.clearScreen();
			screen.printMap(output);
			grid.score(obstacle);
			Thread.sleep(30);
			obstacle.modifyPosition();
		}
	    return true;	
	}
}
