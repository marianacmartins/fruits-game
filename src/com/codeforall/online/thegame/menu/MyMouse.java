package com.codeforall.online.thegame.menu;

import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.mouse.MouseEvent;
import com.codeforall.online.simplegraphics.mouse.MouseEventType;
import com.codeforall.online.simplegraphics.mouse.MouseHandler;
import com.codeforall.online.thegame.Game;

import java.io.IOException;

public class MyMouse implements MouseHandler {
    private Mouse mouse;
    private PlayButton playButton;
    private Game game;

    public MyMouse(PlayButton playButton, Game game){
        this.playButton=playButton;
        this.game = game;
    }



    public void init(){
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(playButton.getIsOn()) {

            if (mouseEvent.getY() >= playButton.getTop() && mouseEvent.getY() <= playButton.getBottom() && mouseEvent.getX() >= playButton.getLeft() && mouseEvent.getX() <= playButton.getRight()) {

                new Thread(() -> {
                    try {
                        game.gameInit();
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

}
