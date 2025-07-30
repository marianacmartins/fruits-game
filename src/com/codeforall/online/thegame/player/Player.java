
package com.codeforall.online.thegame.player;

import com.codeforall.online.simplegraphics.pictures.Picture;
import com.codeforall.online.thegame.fruits.Fruit;

public class Player {
    private Picture playerPicture;
    private int rightLimit;
    private int leftLimit;
    private boolean movePlayer = true;
    private int life;


    public Player(Picture playerPicture){
        this.playerPicture = playerPicture;
        playerPicture.draw();
        life = 3;
    }

    public void setRightLimit(int canvasRightLimit){
        rightLimit = canvasRightLimit;
    }

    public void setLeftLimit(int canvasLeftLimit){
        leftLimit = canvasLeftLimit;
    }

    public void moveRight(){
        if (movePlayer) {

            if (playerPicture.getX() < (rightLimit - (playerPicture.getWidth()))) {
                playerPicture.translate(10, 0);
            }
        }

    }

    public void moveLeft(){
        if (movePlayer) {
            if (playerPicture.getX() > 0) {
                playerPicture.translate(-10, 0);
            }
        }
    }

    public boolean setMovePlayer(boolean movePlayer){
        return this.movePlayer=movePlayer;
    }

    public int getTop(){
        return playerPicture.getY();
    }

    public int getLeft(){
        return playerPicture.getX();
    }

    public int getRight(){
        return playerPicture.getX() + playerPicture.getWidth();
    }

    public int getBottom(){
        return playerPicture.getY() + playerPicture.getHeight();
    }

    public void decreaseLife() {
        life--;
    }
    public int getLife() {
        return life;
    }
}

