package com.codecool.termlib;

public class Czigaretta {

	public static Obstacle obstacle = new Obstacle(140, 30);
  
	public static Dino dino = new Dino(10, 28);

	public static void main(String[] args) throws InterruptedException {
		ScreenGrid grid = new ScreenGrid();
		Terminal screen = new Terminal();
		screen.init();

		String[][] output;
		while (true){
			output = grid.getGrid();
			grid.init();
			grid.refreshGrid(dino, obstacle);
			screen.clearScreen();
			screen.printMap(output);
			Thread.sleep(30);
			obstacle.modifyPosition();
			dino.jump();
		}
	}
}
