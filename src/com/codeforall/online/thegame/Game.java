package com.codeforall.online.thegame;

import com.codeforall.online.simplegraphics.graphics.Canvas;
import com.codeforall.online.simplegraphics.graphics.Text;
import com.codeforall.online.simplegraphics.pictures.Picture;
import com.codeforall.online.thegame.fruits.FruitsManager;
import com.codeforall.online.thegame.fruits.Fruit;
import com.codeforall.online.thegame.menu.MyMouse;
import com.codeforall.online.thegame.menu.PlayButton;
import com.codeforall.online.thegame.player.MyKeyboard;
import com.codeforall.online.thegame.player.Player;
import com.codeforall.online.thegame.score.SavedScore;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Game {
    public static final String PREFIX = "resources/";
    private int score;
    private int finalScore;
    private double fruitCreationRate = 0.8;
    private boolean gameOver = false;
    private FruitsManager fruitsManager;
    private SavedScore savedScore = new SavedScore();
    private PlayButton playButton;
    private Text lifeText;


    public void gameMenu() {

        //menu
        Picture menu = new Picture(0, 0, Game.PREFIX + "menu.png");
        Canvas.getInstance().show(menu);

        //play button
        playButton = new PlayButton(new Picture(550, 300, Game.PREFIX + "play.png"));

        //mouse
        MyMouse myMouse = new MyMouse(playButton, this);
        myMouse.init();

    }

    public void gameInit() throws InterruptedException, IOException {
        //delete play button
        playButton.setIsOn(false);

        //background
        Picture background = new Picture(0, 0, Game.PREFIX + "background.png");
        Canvas.getInstance().show(background);

        //character
        Player player = new Player(new Picture(0, 370, Game.PREFIX + "player2.png"));
        player.setRightLimit(background.getWidth());
        player.setLeftLimit(background.getHeight());

        //keyboard
        MyKeyboard myKeyboard = new MyKeyboard(player);
        myKeyboard.init();

        checkScoreFile();

        //score
        Text text = new Text(20, 10, "score:" + score);
        text.draw();

        //life
        lifeText = new Text(20, 30, "Life: " + player.getLife());
        lifeText.draw();

        //fruits
        fruitsManager = new FruitsManager();

        while (!gameOver) {

            Thread.sleep(130);

            if (Math.random() > fruitCreationRate) {
                if (score != 0 && score % 32 == 0) {
                    fruitsManager.creatFruitsDifficulty();
                }
                fruitsManager.createFruits();
            }

            fruitsManager.moveAllFruits();

            collisionWin(fruitsManager.getFruits(), player);

            text.setText("Score: " + score);

            endGame(fruitsManager.getFruits(), background, player);
        }
    }

    private void checkScoreFile() throws IOException {
        File file = new File(Game.PREFIX + "score.txt");
        if (!file.exists()) {
            savedScore.writeHighScore(0);
        }
    }

    public void collisionWin(List<Fruit> fruits, Player player) {
        for (Fruit fruit : fruits) {
            if (!fruit.isCollided() && fruit.getPicture().getY() >= player.getTop() && fruit.getPicture().getY() <= player.getBottom() && fruit.getPicture().getX() >= player.getLeft() && fruit.getPicture().getX() <= player.getRight()) {
                fruit.getPicture().delete();
                fruit.setMoveFruits(false);
                fruit.setCollision(true);
                score += 10;
                finalScore = score;
                fruitsManager.decrementActiveFruits();
            }
        }
    }

    public int getScore() {
        return finalScore;
    }

    public void setHighScore(int finalScore) {
        savedScore.setGameScore(finalScore);
    }

    public SavedScore getSavedScore() {
        return savedScore;
    }

    public void controlerHighScore() throws IOException {

        int lastHighScore = Integer.parseInt((getSavedScore().readHighScore()).trim());

        if (finalScore > lastHighScore) {
            getSavedScore().writeHighScore(finalScore);
        }
    }

    public void highScoreBuilder() throws IOException {
        setHighScore(getScore());
        controlerHighScore();
        Text highScore = new Text(880, 10, "High Score: " + getSavedScore().readHighScore());
        highScore.draw();
    }

    public void endGame(List<Fruit> fruits, Picture picture, Player player) throws IOException {

        for (int i = fruits.size() - 1; i >= 0; i--) { // Run the list backwords
            Fruit fruit = fruits.get(i);

            if (fruit.getPicture().getY() >= fruit.getCANVAS_HEIGHT()) {
                fruit.getPicture().delete();
                fruits.remove(i);
                fruitsManager.decrementActiveFruits();
                player.decreaseLife();
                lifeText.setText("Life: " + player.getLife());


                if (player.getLife() <= 0) {
                    new Picture(140, 80, Game.PREFIX + "gameover2.png").draw();
                    player.setMovePlayer(false);
                    gameOver = true;
                    highScoreBuilder();
                }
            }
        }
    }
}





