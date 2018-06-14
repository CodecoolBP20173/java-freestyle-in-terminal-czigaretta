package com.codecool.termlib;

import java.util.Random;

public class Obstacle {

    private int x;
    private int y;
    private int prevx;
    private int prevy;
    private int startingx;
    private Random random = new Random();
    private String[][] obstacleShape = {{" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "},
                                        {"\u001B[32m█", " ", "█", "█\u001B[0m", " ", " "},
                                        {"\u001B[32m█", "█", "█", "█", " ", "█\u001B[0m"},
                                        {" ", " ", "\u001B[32m█", "█", "█", "█\u001B[0m"},
                                        {" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "},
                                        {" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "},
                                        {" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "}};

    public Obstacle(int x, int y) {
        this.x = x;
        this.prevx = x;
        this.y = y;
        this.prevy = y;
        this.startingx = x;
    } 

    public Obstacle(int x, int y, String[][] shape) {
        this.x = x;
        this.y = y;
        this.obstacleShape = shape;
    }
    
    public void setXPosition(int newX) {
        this.x = newX;
    }

    public void setYPosition(int newY) {
        this.y = newY;
    }

    public void setShape(String[][] newShape) {
        this.obstacleShape = newShape;
    }

    public int getXPosition() {
        return this.x;
    }

    public int getYPosition() {
        return this.y;
    }

    public String[][] getShape() {
        return this.obstacleShape;
    }

    public void modifyPosition(Terminal screen){
        int n = random.nextInt(150)-30;
        this.prevx = this.x;
        this.x -= 3;
        if (x < 1){
             this.x = this.startingx + n;
        }
        screen.print(this.x, this.y, this.prevx, this.prevy, this.obstacleShape);
    }

    public void modifyPosition(int amount) {
        this.x -= amount;
    }
}
