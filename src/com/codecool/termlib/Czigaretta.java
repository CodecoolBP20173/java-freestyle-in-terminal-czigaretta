package com.codecool.termlib;

public class Czigaretta {
	public static void main(String[] args){
		Terminal screen = new Terminal();
		screen.clearScreen();
		for (int i = 0; i < 5000; i++){
			System.out.print("c");
		}
		screen.clearScreen();
	}
}
