package com.codecool.termlib;

public class ScreenGrid {
    public String[][] grid = new String[150][40];
    
    public void refreshScreen(){
        Dino dino = new Dino();

        for (int i = 0; i<dino.shape.length; i++){
            for (int j = 0; j<dino.shape[i].length; j++){
                grid[i+dino.y][j+dino.x] = dino.shape[i][j]
            }
        }

    }
     
}