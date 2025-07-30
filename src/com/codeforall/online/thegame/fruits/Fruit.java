package com.codeforall.online.thegame.fruits;

import com.codeforall.online.simplegraphics.pictures.Picture;

public class Fruit {

    private Picture picture;
    private boolean moveFruits = true;
    private boolean collision;
    private final int CANVAS_HEIGHT = 465;

    public Fruit(Picture picture){
        this.picture=picture;
        this.picture.draw();
        this.collision=false;
    }

    public Picture getPicture() {
        return picture;
    }

    public void move() throws InterruptedException {
        if(moveFruits) {

            if (picture.getY() < CANVAS_HEIGHT) {

                picture.translate(0, 7);
            }
        }
    }


    public boolean setMoveFruits (boolean moveFruits){
        this.moveFruits=moveFruits;
        return this.moveFruits;
    }

    public boolean isCollided(){
        return collision;
    }

    public void setCollision(boolean collision){
        this.collision=collision;
    }

    public int getCANVAS_HEIGHT() {
        return CANVAS_HEIGHT;
    }
}
