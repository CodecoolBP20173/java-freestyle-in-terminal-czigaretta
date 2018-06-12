package com.codecool.termlib;

public class Dino {

     private int x = 13;
     private int y = 13;
     private int[][] dinoShape = [[0, 0, 1, 0, 0],
				  [0, 0, 1, 0, 0],
				  [1, 1, 1, 1, 1],
				  [0, 0, 1, 0, 0],
				  [0, 0, 1, 0, 0]];
     
     public void setXPosition(int newX) {
         this.x = newX;
     }

     public void setYPosition(int newY) {
         this.y = newY;
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
