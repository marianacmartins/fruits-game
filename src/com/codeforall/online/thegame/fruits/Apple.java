package com.codeforall.online.thegame.fruits;

import com.codeforall.online.simplegraphics.pictures.Picture;
import com.codeforall.online.thegame.Game;

public class Apple extends Fruit {

    public Apple(int x){
        super(new Picture(x,140, Game.PREFIX+"apple.png"));
    }

    @Override
    public void move() throws InterruptedException {
        super.move();
    }

}
