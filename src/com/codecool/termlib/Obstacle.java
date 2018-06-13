package com.codecool.termlib;

public class Obstacle {

     private int x;
     private int y;
     private String[][] obstacleShape = {{" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "},
				         {"\u001B[32m█", " ", "█", "█\u001B[0m", " ", " "},
				         {"\u001B[32m█", "█", "█", "█", " ", "█\u001B[0m"},
				         {" ", " ", "\u001B[32m█", "█", "█", "█\u001B[0m"},
				         {" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "},
				         {" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "},
				         {" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "}};
  
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
         this.x--;
     }

     public void modifyPosition(int amount) {
         this.x -= amount;
     }
}
