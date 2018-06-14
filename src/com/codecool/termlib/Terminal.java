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

    public void resetStyle() {
    }

    /**
     * Clear the whole screen.
     *
     * Might reset cursor position.
     */

    public void init(){
        System.out.print("\033[?25l");
        for (int i = 0; i < 200; i++){
            System.out.println(CONTROL_CODE + String.valueOf(36) + ";" + String.valueOf(i) + MOVE + '▔');
        }
    }

    public static void raw(boolean on) {
	String s = on? "" : "-";
	try { 
            Runtime.getRuntime().exec(new String [] {
	    "sh", "-c", "stty "+s+"raw </dev/tty"}).waitFor();
	} catch (Exception e) {
        }
    }

    public void clearScreen() {
	System.out.print(CONTROL_CODE + "0;0" + MOVE + CONTROL_CODE + CLEAR);  
    	System.out.flush(); 
    }

    public void printMap(String[][] map) {
	for(int i = 0; i < map.length; i++){
	    for(int j = 0; j < map[i].length; j++){
            if (map[i][j] != " "){
                if (i == map.length-1){
                    System.out.println(CONTROL_CODE + String.valueOf(i) + ";" + String.valueOf(j) + MOVE + map[i][j]);
                }
                else {
                    System.out.print(CONTROL_CODE + String.valueOf(i) + ";" + String.valueOf(j) + MOVE + map[i][j]);
                }
            }
	    }
	    System.out.print("\u001b[1E");
	}
    }
    public void gameOver() {
        clearScreen();
        System.out.print("    ____                            ___                          \u001b[1E"
			 +"   / ___|  __ _  _ __ ___    ___   / _ \\ __   __ ___  _ __ \u001b[1E" 
			 +"  | |  _  / _` || '_ ` _ \\  / _ \\ | | | |\\ \\ / // _ \\| '__|\u001b[1E"
			 +"  | |_| || (_| || | | | | ||  __/ | |_| | \\ V /|  __/| |       \u001b[1E"
			 +"   \\____| \\__,_||_| |_| |_| \\___|  \\___/   \\_/  \\___||_|  \u001b[1E"
                         +"                                                                \u001b[1E"
                         +"			                                           \u001b[1E"
                         +"   Your score is: " + ScreenGrid.score + "                      \u001b[1E"
		         +"			                                           \u001b[1E"
			 +"   Press 'r' to restart the game, 'q' to exit\n");
    }

    public void menu() {
        clearScreen();
        System.out.print("   ____   _                 ____               _       \u001b[1E"
			+"  |  _ \\ (_) _ __    ___   |  _ \\  _   _  ___ | |__  \u001b[1E" 
			+"  | | | || || '_ \\  / _ \\  | |_) || | | |/ __|| '_ \\ \u001b[1E" 
			+"  | |_| || || | | || (_) | |  _ < | |_| |\\__ \\| | | |\u001b[1E"
			+"  |____/ |_||_| |_| \\___/  |_| \\_\\ \\__,_||___/|_| |_|\u001b[1E"
                        +"                                                     \u001b[1E"
                        +"			                               \u001b[1E"
                        +"			                               \u001b[1E"
		        +"   Press 's' to start the game\n");                            
    }

    /**
     * Move cursor to the given position.
     *
     * Positions are counted from one.  Cursor position 1,1 is at
     * the top left corner of the screen.
     *
     * @param x Column number.
     * @param y Row number.
     */

    public void print(int x, int y, int prevx, int prevy, String[][] shape){
        String pixel = new String();
        int yIndex;
        int xIndex;
        int prevyIndex;
        int prevxIndex;
        for(int i = Math.min(y, prevy); i < shape.length + Math.max(y, prevy); i++){
            yIndex = i - y;
            prevyIndex = i - prevy;
            for(int j = Math.min(x, prevx); j < shape[0].length + Math.max(x, prevx); j++){
                xIndex = j - x;
                prevxIndex = j - prevx;
                if (((y < prevy && i >= prevy && i < y+shape.length) || (y > prevy && i >= y && i < prevy + shape.length)) &&
                ((x < prevx && j >= prevx && j < x+shape[i].length) || (x > prevx && j >= x && j <prevx+shape[i].length))){
                    if (shape[yIndex][xIndex] != shape[prevyIndex][prevxIndex]){
                        pixel = shape[yIndex][xIndex];
                        System.out.print(CONTROL_CODE + Integer.toString(i) + ";" + Integer.toString(j) + MOVE + pixel);
                    }
                }
                else {
                    try {
                        pixel = shape[yIndex][xIndex];
                        System.out.print(CONTROL_CODE + Integer.toString(i) + ";" + Integer.toString(j) + MOVE + pixel);
                    }
                    catch (IndexOutOfBoundsException e) {
                        pixel = " ";
                        if (((i >= y && i < y+shape.length) && (j >= x && j < x + shape[yIndex].length)) ||
                        ((i >= prevy && i < prevy+shape.length) && (j >= prevx && j < prevx + shape[prevyIndex].length))){
                            System.out.print(CONTROL_CODE + Integer.toString(i) + ";" + Integer.toString(j) + MOVE + pixel);
                        }
                    }
                }
            }
        }
    }

    public void moveTo(Integer x, Integer y) {
    }

    /**
     * Set the foreground printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The color to set.
     */
    public void setColor(Color color) {
    }

    /**
     * Set the background printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The background color to set.
     */
    public void setBgColor(Color color) {
    }

    /**
     * Make printed text underlined.
     *
     * On some terminals this might produce slanted text instead of
     * underlined.  Cannot be turned off without turning off colors as
     * well.
     */
    public void setUnderline() {
    }

    /**
     * Move the cursor relatively.
     *
     * Move the cursor amount from its current position in the given
     * direction.
     *
     * @param direction Step the cursor in this direction.
     * @param amount Step the cursor this many times.
     */
    public void moveCursor(Direction direction, Integer amount) {
    }

    /**
     * Set the character diplayed under the current cursor position.
     *
     * The actual cursor position after calling this method is the
     * same as beforehand.  This method is useful for drawing shapes
     * (for example frame borders) with cursor movement.
     *
     * @param c the literal character to set for the current cursor
     * position.
     */
    public void setChar(char c) {
    }

    /**
     * Helper function for sending commands to the terminal.
     *
     * The common parts of different commands shall be assembled here.
     * The actual printing shall be handled from this command.
     *
     * @param commandString The unique part of a command sequence.
     */
    private void command(String commandString) {
    }
}
