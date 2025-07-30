package com.codeforall.online.thegame.menu;

import com.codeforall.online.simplegraphics.pictures.Picture;

public class PlayButton {
    private Picture playPicture;
    private boolean isOn = true;


    public PlayButton(Picture playPicture) {
        this.playPicture=playPicture;
        playPicture.draw();
    }

    public Picture getPlayPicture() {
        return playPicture;
    }

    public int getTop(){
        return playPicture.getY();
    }

    public int getLeft(){
        return playPicture.getX();
    }

    public int getRight(){
        return playPicture.getX() + playPicture.getWidth();
    }

    public int getBottom(){
        return playPicture.getY() + playPicture.getHeight();
    }

    public boolean setIsOn(boolean IsOn){
       return this.isOn=IsOn;
    }

    public boolean getIsOn(){
        return this.isOn;
    }



}
