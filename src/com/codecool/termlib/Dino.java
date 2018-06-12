package com.codecool.termlib;

public class Dino {

     private int x;
     private int y;
     private String[][] dinoShape = {{"0", "0", "1", "0", "0"},
				     {"0", "0", "1", "0", "0"},
				     {"1", "1", "1", "1", "1"},
				     {"0", "0", "1", "0", "0"},
				     {"0", "0", "1", "0", "0"}};
  
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

     public void jump(int newX) {
         this.x = newX;
     }
}
