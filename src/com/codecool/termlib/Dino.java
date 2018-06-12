package com.codecool.termlib;

public class Dino {

     private int x = 10;
     private int y = 0;
     private String[][] dinoShape = {{"0", "0", "1", "0", "0"},
				  {"0", "0", "1", "0", "0"},
				  {"1", "1", "1", "1", "1"},
				  {"0", "0", "1", "0", "0"},
				  {"0", "0", "1", "0", "0"}};
     
    public void setXPosition(int newX) {
            this.x = newX;
        }

     public void setYPosition(int newY) {
         this.y = newY;
     }

    public String[][] getShape() {
         return this.dinoShape;
     }

     public int getXPosition() {
         return this.x;
     }

     public int getYPosition() {
         return this.y;
     }

     public void jump(int newY) {
         this.y = newY;
     }
}
