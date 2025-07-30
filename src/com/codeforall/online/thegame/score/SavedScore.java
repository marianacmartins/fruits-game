package com.codeforall.online.thegame.score;

import com.codeforall.online.thegame.Game;

import java.io.*;

public class SavedScore {

    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private int gameScore;


    public String writeHighScore(int gameScore) throws IOException {

        fileWriter = new FileWriter(Game.PREFIX+"score.txt");
        bufferedWriter = new BufferedWriter(fileWriter);
        String highScore = gameScore + "";
        bufferedWriter.write(highScore);
        bufferedWriter.flush();
        bufferedWriter.close();
        return highScore;

    }

    public String readHighScore() throws IOException {
        fileReader = new FileReader(Game.PREFIX + "score.txt");
        bufferedReader = new BufferedReader(fileReader);

            String result = "";
            String line = bufferedReader.readLine();


            while (line != null) {
                result += line + "\n";
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            return result;

    }

    public void setGameScore(int finalScore){
        this.gameScore = finalScore;
    }
}
