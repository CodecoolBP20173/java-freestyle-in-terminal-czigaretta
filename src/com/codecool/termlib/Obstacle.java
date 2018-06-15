package com.codecool.termlib;

import java.util.Random;

public class Obstacle {

     private int x;
     private int y;
     private int startingX;
     private Random random = new Random();
     private String[][] obstacleShape = {{" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "},
					 {"\u001B[32m█", " ", "█", "█\u001B[0m", " ", " "},
				         {"\u001B[32m█", "█", "█", "█", " ", "█\u001B[0m"},
				         {" ", " ", "\u001B[32m█", "█", "█", "█\u001B[0m"},
				         {" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "},
				         {" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "},
				         {" ", " ", "\u001B[32m█", "█\u001B[0m", " ", " "}};
  
     public Obstacle(int x, int y) {
         this.startingX = x;
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

     public int modifyPosition() {
	 int n = random.nextInt(50) - 30;
         this.x-=3;
         if (x < 1){
             this.x = this.startingX + n;
             return 1;
         }
         return 1;
     }

     public int modifyPosition(int amount) {
         this.x -= amount;
         if (x < 1){
            this.x = this.startingX;
            return 1;
         }
         return 0;   
     }
}
