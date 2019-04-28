package utn;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.ArrayUtils;
import utn.db.Jdbc;
import utn.model.Word;
import utn.model.Player;

import java.sql.Date;

public class Game {
    private Jdbc jdbc = new Jdbc();
    private boolean avaliable = true;
    private Word word;
    private String wordDB;

    public Game (){

        this.word = jdbc.getWord();
        this.wordDB = word.getWord();
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
        /*if (!player.isWinner() && !word.getWord().isEmpty() && player.alphabetEmpty()){
            System.out.println("/--------------JUGADOR "+ player.getPlayerName() +"-----------------/");
            System.out.println("Palabra: "+ word);
        }*/

        if (!player.isWinner() && !word.getWord().isEmpty()){
            System.out.println("/--------------JUGADOR "+ player.getPlayerName() +"-----------------/");
            if (!player.alphabetEmpty()){ //si el abecedario no esta vacio, el jugador elige la letra, si esta vacio cambia el boolean de si hay letras en falso
                char letter = player.getRandomLetter();
                System.out.println("Eligio la letra: " + letter);
                System.out.println("Palabra: "+ word);

                if(word.getWord().contains(String.valueOf(letter))){
                    while (word.getWord().contains(String.valueOf(letter))){  //mientras la letra que eligio este en la palabra entra en el while
                        word.setWord(word.getWord().replace(String.valueOf(letter),"")); //reemplaza la letra por espacio vacio
                        player.deleteLetter(letter); //elimina la letra
                        System.out.println("Vidas restantes: " +player.getLives());
                        System.out.println("/---------------ABECEDARIO------------------/");
                        System.out.println(player.getAlphabet());
                        System.out.println("/------------------------------------------/");
                    }
                    if(word.getWord().isEmpty()){
                        System.out.println("Jugador GANADOR: " + player.getPlayerName());
                        jdbc.insertWinner(player,this.wordDB);
                        player.setWinner(true);
                    }
                }
                else
                {
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
            else{
                player.setWords(false);
            }

        }

        avaliable = true;
        notify();
    }


    }


