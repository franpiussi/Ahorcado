package utn;

import org.apache.commons.lang3.ArrayUtils;
import utn.model.Player;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        Game game = new Game();
        Thread player1 = new Player("Franco",game);
        Thread player2 = new Player("Guido",game);
        player1.start();
        player2.start();



    }
}
