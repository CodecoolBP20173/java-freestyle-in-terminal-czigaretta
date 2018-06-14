package com.codecool.termlib;

public class ScreenGrid {

    private static final int WIDTH = 150;

    private static final int HEIGHT = 40;

    private String[][] grid = new String[HEIGHT][WIDTH];

    public void init(){
        for (int i = 0; i<this.grid.length; i++){
            for (int j = 0; j<this.grid[i].length; j++)
            if (i == this.grid.length - 4) {
                this.grid[i][j] = "▔";
            } else {
                this.grid[i][j] = " ";
            }
        }
    }
    
    public boolean refreshGrid(Dino dino, Obstacle obstacle){

        String[][] dinoShape = dino.getShape();
        int dinoX = dino.getXPosition();
        int dinoY = dino.getYPosition();
        for (int i = 0; i<dinoShape.length && i+dinoY < HEIGHT; i++){
            for (int j = 0; j<dinoShape[i].length && j+dinoX < WIDTH; j++){
                this.grid[i+dinoY][j+dinoX] = dinoShape[i][j];
            }
        }
        
        String[][] obstacleShape = obstacle.getShape();
        int obstacleX = obstacle.getXPosition();
        int obstacleY = obstacle.getYPosition();
        for (int i = 0; i < obstacleShape.length && i+obstacleY < HEIGHT; i++){
            for(int j = 0; j < obstacleShape[i].length && j+obstacleX < WIDTH; j++){
                this.grid[i+obstacleY][j+obstacleX] = obstacleShape[i][j];
            }
        }

        return true;
    }

    public String[][] getGrid(){
        return this.grid;
    }
     
}
