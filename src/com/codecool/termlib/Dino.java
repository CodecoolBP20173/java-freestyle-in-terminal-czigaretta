package com.codecool.termlib;

public class Dino {

    private int x;
    private int y;
    private int prevx;
    private int prevy;
    private boolean jumping = false; 
    private long startTime;
    private long runTime = System.currentTimeMillis();
    private int shape = 1; 
    private String[][] dinoShape = {{" ", " ", " ", "\u001B[36m█", "▀", "█", "█", "█\u001B[0m"},
                                    {" ", " ", " ", "\u001B[36m█", "█", "█", "█", "█\u001B[0m"},
                                    {" ", " ", " ", "\u001B[36m█", "█", "█\u001B[0m", " ", " "},
                                    {"\u001B[36m█", " ", "█", "█", "█", "█", "▄\u001B[0m", " "},
                                    {"\u001B[36m▝", "█", "█", "█", "█", " ", "▝\u001B[0m", " "},
                                    {" ", " ", "\u001B[36m█", " ", "█\u001B[0m", " ", " ", " "}};

    public Dino(int x, int y) {
        this.x = x;
        this.y = y;
        this.prevx = x;
        this.prevy = y;
    } 
    
    public void show(Terminal screen) {
        screen.print(this.x, this.y, this.prevx, this.prevy, this.dinoShape);
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

    public boolean jump(Terminal screen) {
        if (jumping){
            if (this.y <= 30){
                float time = (System.currentTimeMillis() - this.startTime);
                this.prevy = this.y;
                this.y = 40 -(((int) Math.round((6000*time-0.5*13*time*time)/100000)) + 10);
                if (this.y <= 30){
                    screen.print(this.x, this.y, this.prevx, this.prevy, this.dinoShape);
                }
                return true;
            }
            else {
                this.jumping = false;
                this.prevy = this.y;
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
