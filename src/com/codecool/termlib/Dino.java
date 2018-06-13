package com.codecool.termlib;

public class Dino {

     private int x;
     private int y;
     private long start = System.currentTimeMillis();
     private String[][] dinoShape = {{" ", " ", " ", "█", "▀", "█", "█", "█"},
				     {" ", " ", " ", "█", "█", "█", "█", "█"},
				     {" ", " ", " ", "█", "█", "█", " ", " "},
				     {"█", " ", "█", "█", "█", "█", "▄", " "},
				     {"▝", "█", "█", "█", "█", " ", "▝", " "},
				     {" ", " ", "█", " ", "█", " ", " ", " "}};
  
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

     public void jump() {
         if (this.y < 30){
            float time = (System.currentTimeMillis() - this.start);
            this.y = 40-(((int) Math.round((10000*time-0.5*20*time*time)/100000)) + 10);
        }
     }
}
