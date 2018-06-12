package com.codecool.termlib;

public class ScreenGrid {

    private String[][] grid = new String[40][150];

    public void init(){
        for (int i = 0; i<this.grid.length; i++){
            for (int j = 0; j<this.grid[i].length; j++)
                this.grid[i][j] = " ";
        }
    }
    
    public void refreshGrid(){
        Dino dino = new Dino();
        
        
        String[][] dinoShape = dino.getShape();
        int dinoX = dino.getXPosition();
        int dinoY = dino.getYPosition();
        for (int i = 0; i<dinoShape.length; i++){
            for (int j = 0; j<dinoShape[i].length; j++){
                this.grid[i+dinoY][j+dinoX] = dinoShape[i][j];
            }
        }

    }

    public String[][] getGrid(){
        return this.grid;
    }
     
}