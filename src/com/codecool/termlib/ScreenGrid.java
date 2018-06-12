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
        for (int i = 0; i<dinoShape.length && i+dinoY < 40; i++){
            for (int j = 0; j<dinoShape[i].length && j+dinoX < 150; j++){
                this.grid[i+dinoY][j+dinoX] = dinoShape[i][j];
            }
        }
        
        
        Obstacle obstacle = new Obstacle();
        String[][] obstacleShape = obstacle.getShape();
        int obstacleX = obstacle.getXPosition();
        int obstacleY = obstacle.getYPosition();
        for (int i = 0; i < obstacleShape.length && i+obstacleY < 40; i++){
            for(int j = 0; j < obstacleShape.length && j+obstacleX < 150; j++){
                this.grid[i+obstacleY][j+obstacleX] = obstacleShape[i][j];
            }
        }
    }

    public String[][] getGrid(){
        return this.grid;
    }
     
}