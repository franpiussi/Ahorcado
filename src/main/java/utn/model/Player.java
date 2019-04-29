package utn.model;

import org.apache.commons.lang3.ArrayUtils;
import utn.Game;

import java.util.Random;


public class Player extends Thread{

    private int lives;
    private String name;
    private Game game;
    private Random rand;

    static private boolean words = true;
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


    public void killLife(){
        this.lives--;
    }

    public static char[] getAlphabet() {
        return alphabet;
    }

    public boolean alphabetEmpty(){
        return ArrayUtils.isEmpty(this.alphabet);
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

    public static boolean isWinner() {
        return winner;
    }

    public static void setWinner(boolean winner) {
        Player.winner = winner;
    }

    public static void setWords(boolean words) {
        Player.words = words;
    }

    @Override
    public void run() {

        while (this.lives > 0 && !winner && words){
            game.play(this);
        }

        if (this.lives == 0 || winner || !words){
            if(!words){
                System.out.println("SE ACABARON LAS LETRAS DEL ABECEDARIO");
            }
            this.interrupt();
        }
    }


}
