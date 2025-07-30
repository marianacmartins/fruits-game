package com.codeforall.online.thegame.fruits;

import java.util.LinkedList;
import java.util.List;

public class FruitsManager {

    private List<Fruit> fruits;
    private final int CANVAS_WIDTH = 950;
    private int activeFruits = 0;
    private int fruitLimit = 1;

    public FruitsManager() {

        fruits = new LinkedList<>();
    }

    public void createFruits() {

        if (activeFruits > fruitLimit) {
            return;
        }

        Fruit fruit;

        if (Math.random() < 0.5) {
                fruit = new Apple((int) (Math.random() * CANVAS_WIDTH));
            } else {
                fruit = new Orange((int) (Math.random() * CANVAS_WIDTH));
            }

            fruit.getPicture().draw();
            activeFruits++;
            fruits.add(fruit);
    }

    public void creatFruitsDifficulty(){
        if (activeFruits > fruitLimit) {
            return;
        }
        Fruit fruit;
        fruitLimit++;

        if (Math.random() < 0.5) {
            fruit = new Apple((int) (Math.random() * CANVAS_WIDTH));
        } else {
            fruit = new Orange((int) (Math.random() * CANVAS_WIDTH));
        }

        fruit.getPicture().draw();
        activeFruits++;
        fruits.add(fruit);
    }

    public void moveAllFruits() throws InterruptedException {
        for (Fruit fruit : fruits) {
            fruit.move();
        }
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void decrementActiveFruits() {
        activeFruits--;
    }
}
