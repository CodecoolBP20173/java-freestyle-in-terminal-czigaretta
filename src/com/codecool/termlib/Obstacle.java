package com.codecool.termlib;

public class Obstacle {

     private int x;
     private int y;
     private String[][] obstacleShape = {{"1", "1", "1"},
				         {"1", "1", "1"},
				         {"1", "1", "1"}};
  
     public Obstacle(int x, int y) {
         this.x = x;
         this.y = y;
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

     public void modifyPosition() {
         this.y--;
     }

     public void modifyPosition(int amount) {
         this.y -= amount;
     }
}
