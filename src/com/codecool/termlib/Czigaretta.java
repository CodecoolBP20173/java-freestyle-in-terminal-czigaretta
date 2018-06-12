package com.codecool.termlib;

public class Czigaretta {
	public static void main(String[] args){
		ScreenGrid grid = new ScreenGrid();
		Terminal screen = new Terminal();

		while (True) {
			screen.clearScreen();
			screen.printMap(grid.grid);
			grid.refreshScreen()
			Thread.sleep(500)
		}
	}
}
