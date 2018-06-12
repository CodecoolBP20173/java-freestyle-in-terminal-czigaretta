package com.codecool.termlib;

public class Czigaretta {
	public static void main(String[] args){
		Terminal screen = new Terminal();
		screen.clearScreen();
		int[][] map = new int[20][180];
		screen.printMap(map);
		screen.clearScreen();
	}
}
