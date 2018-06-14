package com.codecool.termlib;

public class Dino {

    private int x;
    private int y;
    private boolean jumping = false; 
    private long startTime;
    private String[][] dinoShape = {{" ", " ", " ", "\u001B[36m█", "▀", "█", "█", "█\u001B[0m"},
                                    {" ", " ", " ", "\u001B[36m█", "█", "█", "█", "█\u001B[0m"},
                                    {" ", " ", " ", "\u001B[36m█", "█", "█\u001B[0m", " ", " "},
                                    {"\u001B[36m█", " ", "█", "█", "█", "█", "▄\u001B[0m", " "},
                                    {"\u001B[36m▝", "█", "█", "█", "█", " ", "▝\u001B[0m", " "},
                                    {" ", " ", "\u001B[36m█", " ", "█\u001B[0m", " ", " ", " "}};

    public Dino(int x, int y) {
        this.x = x;
        this.y = y;
    } 
    
    public void setXPosition(int newX) {
        this.x = newX;
    }

    public void setYPosition(int newY) {
        this.y = newY;
    }

    public void setShape(String[][] newShape) {
        this.dinoShape = newShape;
    }

    public int getXPosition() {
        return this.x;
    }

    public int getYPosition() {
        return this.y;
    }

    public String[][] getShape() {
        return this.dinoShape;
    }

    public boolean jump() {
        if (jumping){
            if (this.y <= 30){
                float time = (System.currentTimeMillis() - this.startTime);
                this.y = 40 -(((int) Math.round((6000*time-0.5*15*time*time)/100000)) + 10);
                return true;
            }
            else {
                this.jumping = false;
                this.y = 30;
                return false;
            }
        }
        else {
            this.jumping = true;
            this.startTime = System.currentTimeMillis();
            return true;
        }
    }
}
