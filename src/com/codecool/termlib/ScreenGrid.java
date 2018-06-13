package com.codecool.termlib;

public class ScreenGrid {

    private static final int WIDTH = 150;

    private static final int HEIGHT = 40;

    private String[][] grid = new String[HEIGHT][WIDTH];

    public void init(){
        for (int i = 0; i<this.grid.length; i++){
            for (int j = 0; j<this.grid[i].length; j++)
                this.grid[i][j] = " ";
        }
    }

    /*
    public void amIDead(dinoXPosition,dinoYPosition,obstacleXPosition,obstacleYPosition){
        int[] dinoBody = {};
    }
    */
    
    public void refreshGrid(Dino dino, Obstacle obstacle){
        //DDDDDDEEEEEEEEEEEEEEEEAAAAAAAAAAAAAADDDDDDDDDDDD???????????????
        int dinoXPosition = dino.getXPosition();
        int obstacleXPosition = obstacle.getXPosition();
        int dinoYPosition = dino.getYPosition();
        int obstacleYPosition = obstacle.getYPosition();
        for (int move = 0; move < 7; move++){
            for(int obsatclebody = 0; obsatclebody < 8; obsatclebody++){
            if(dinoXPosition+dinoYPosition + move + obsatclebody == obstacleXPosition+obstacleYPosition + obsatclebody){
                System.out.println(dinoXPosition+dinoYPosition);
                System.out.println(obstacleXPosition+obstacleYPosition);
                System.out.println(move);
                // IDE KELL VMI HOGY MI A BRÉ TÖRTÉNJEN HA ÉRINTKEZNEK
            }
            if(dinoXPosition-dinoYPosition - move - obsatclebody == obstacleXPosition-obstacleYPosition - obsatclebody){
                System.out.println(dinoXPosition+dinoYPosition);
                System.out.println(obstacleXPosition+obstacleYPosition);
                System.out.println(move);
            }    
        }
        }

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
    }

    public String[][] getGrid(){
        return this.grid;
    }
     
}
