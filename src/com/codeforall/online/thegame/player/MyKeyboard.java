package com.codeforall.online.thegame.player;

import com.codeforall.online.simplegraphics.keyboard.Keyboard;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.online.simplegraphics.keyboard.KeyboardHandler;


public class MyKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;

    public MyKeyboard(Player player){
        this.player=player;
    }

    public void init(){
        keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_D){
            player.moveRight();
            player.moveRight();
            player.moveRight();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_A){
            player.moveLeft();
            player.moveLeft();
            player.moveLeft();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
