package utn;

import com.sun.org.apache.xpath.internal.operations.Bool;
import utn.db.Jdbc;
import utn.model.Word;
import utn.model.Player;

public class Game {
    private Jdbc jdbc = new Jdbc();
    private boolean avaliable = true;
    private Word word;

    public Game (){

        this.word = jdbc.getWord();
        System.out.println("PALABRA ALEATORIA: "+ word);
    }


    public synchronized void play (Player player){

        while (!avaliable){
            try{
                wait();
            }
            catch (InterruptedException e){
                e.getMessage();
            }
        }

        avaliable = false;
        if (!word.getWord().isEmpty()){
            System.out.println("/--------------JUGADOR "+ player.getPlayerName() +"-----------------/");
            System.out.println("Palabra: "+ word);
        }
        if (!player.isWinner() && !word.getWord().isEmpty()){
            if (!word.getWord().isEmpty() && player.isWinner() == Boolean.FALSE){
                char letter = player.getRandomLetter();

                System.out.println("Eligio la letra: " + letter);

                if(word.getWord().contains(String.valueOf(letter))){
                    while (word.getWord().contains(String.valueOf(letter))){
                        word.setWord(word.getWord().replace(String.valueOf(letter),""));
                        player.deleteLetter(letter);
                        System.out.println("Vidas restantes: " +player.getLives());
                        System.out.println("/---------------ABECEDARIO------------------/");
                        System.out.println(player.getAlphabet());
                        System.out.println("/------------------------------------------/");
                    }
                    if(word.getWord().isEmpty()){
                       System.out.println("Jugador GANADOR: " + player.getPlayerName());
                       player.setWinner(false);
                    }
                }
                else {
                    player.deleteLetter(letter);
                    player.killLife();
                    if (player.getLives() == 0){
                        System.out.println("/---------------------"+ player.getPlayerName() +" esta MUERTO -----------------/");
                    }
                    else{
                        System.out.println("Vidas restantes: " + player.getLives());
                        System.out.println("/---------------ABECEDARIO------------------/");
                        System.out.println(player.getAlphabet());
                        System.out.println("/------------------------------------------/");
                    }
                }
                try{
                    Thread.sleep(1500);
                }
                catch (InterruptedException e){
                    e.getMessage();
                }
        }

        avaliable = true;
        notify();
    }
}
}
