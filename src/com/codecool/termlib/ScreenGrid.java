package com.codecool.termlib;

public class ScreenGrid {

    private static final int WIDTH = 150;

    private static final int HEIGHT = 40;

    private String[][] grid = new String[HEIGHT][WIDTH];

    public static int score = 0;

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

    public boolean checkForDeath(Dino dino, Obstacle obstacle){
        String[][] dinoShape = dino.getShape();
        int dinoX = dino.getXPosition();
        int dinoY = dino.getYPosition();

        String[][] obstacleShape = obstacle.getShape();
        int obstacleX = obstacle.getXPosition();
        int obstacleY = obstacle.getYPosition();

        for (int dy = 0; dy<dinoShape.length; dy++){
            for (int dx = 0; dx<dinoShape[dy].length; dx++){
                for (int oy = 0; oy < obstacleShape.length; oy++){
                    for(int ox = 0; ox < obstacleShape[oy].length; ox++){
                        if(dinoX+dx == obstacleX+ox && dinoY+dy == obstacleY+oy){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static int score(Obstacle obstacle){
        score += obstacle.modifyPosition();
	System.out.println(score);
        return score;
    } 

    public String[][] getGrid(){
        return this.grid;
    }
     
}
