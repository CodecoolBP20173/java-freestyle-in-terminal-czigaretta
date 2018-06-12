package com.codecool.termlib;

public class Czigaretta {
	public static void main(String[] args){
		ScreenGrid grid = new ScreenGrid();
		Terminal screen = new Terminal();

		String[][] output = grid.getGrid();
		grid.init();
		grid.refreshGrid();
		screen.clearScreen();
		screen.printMap(output);
		

	}
}
