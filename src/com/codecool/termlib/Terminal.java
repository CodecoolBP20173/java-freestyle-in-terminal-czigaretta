package com.codecool.termlib;

public class Terminal {
    /**
     * The beginning of control sequences.
     */
    private static final String CONTROL_CODE = "\033[";
    /**
     * Command for whole screen clearing.
     *
     * Might be partitioned if needed.
     */
    private static final String CLEAR = "2J";
    /**
     * Command for moving the cursor.
     */
    private static final String MOVE = "H";
    /**
     * Command for printing style settings.
     *
     * Handles foreground color, background color, and any other
     * styles, for example color brightness, or underlines.
     */
    private static final String STYLE = "m";

    /**
     * Reset printing rules in effect to terminal defaults.
     *
     * Reset the color, background color, and any other style
     * (i.e.: underlined, dim, bright) to the terminal defaults.
     */

    public void clearScreen() {
	System.out.print(CONTROL_CODE + MOVE + CONTROL_CODE + CLEAR);  
    	System.out.flush(); 
    }

    public void printMap(String[][] map) {
	for(int i = 0; i < map.length; i++){
	    for(int j = 0; j < map[i].length; j++){
		System.out.print(map[i][j]);
	    }
	    System.out.println();
	}
    }

}
