package com.codeforall.online.thegame.fruits;

import com.codeforall.online.simplegraphics.pictures.Picture;
import com.codeforall.online.thegame.Game;

public class Orange extends Fruit {

    public Orange(int x) {
        super(new Picture(x, 140, Game.PREFIX+"orange.png"));

    }

    @Override
    public void move() throws InterruptedException {
        super.move();
    }
}
