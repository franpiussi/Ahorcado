package utn.model;

import org.apache.commons.lang3.ArrayUtils;
import utn.Game;

import java.util.Date;
import java.util.Random;


public class Player extends Thread{

    private int lives;
    private String name;
    private Date date;
    private Game game;
    private Random rand;

    static private boolean winner = false;
    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();


    public Player (String name,Game game){
        this.name = name;
        this.lives = 10;
        this.game = game;
        this.rand = new Random();
    }

    public String getPlayerName() {
        return name;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public void killLife(){
        this.lives = this.lives - 1;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public static char[] getAlphabet() {
        return alphabet;
    }
    public static void setAlphabet(char[] alphabet) {
        Player.alphabet = alphabet;
    }

    public char getRandomLetter(){
        return alphabet[rand.nextInt(this.alphabet.length)];
    }

    public void deleteLetter(char letter){
        alphabet = ArrayUtils.removeElement(alphabet,letter);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public static boolean isWinner() {
        return winner;
    }

    public static void setWinner(boolean winner) {
        Player.winner = winner;
    }


    @Override
    public void run() {

        while (this.lives > 0 && !winner){
            game.play(this);
        }
        if (this.lives == 0 && winner){
            this.stop();
        }
    }


}
