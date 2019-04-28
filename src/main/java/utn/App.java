package utn;

import org.apache.commons.lang3.ArrayUtils;
import utn.model.Player;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        Game game = new Game();
        Player player1 = new Player("Franco",game);
        Player player2 = new Player("Guido",game);
        player1.start();
        player2.start();

    }
}
