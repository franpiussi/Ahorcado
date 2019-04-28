package utn.db;
import utn.model.Word;
import utn.model.Player;

import java.sql.*;


public class Jdbc {

    private static Connection myConnection;

    public static Word getWord(){
        Word word = null;
        Statement st = null;
        ResultSet rs = null;

        try{

            myConnection = DriverManager.getConnection("jdbc:mysql://localhost/hanged_game","root","");
            String query = "SELECT id_word,word FROM words ORDER BY RAND() LIMIT 1";
            st = myConnection.prepareStatement(query);
            rs = st.executeQuery(query);
            while(rs.next()){
                word = new Word(rs.getInt("id_word"),rs.getString("word"));
            }
        }

        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            if (rs != null){
                try{
                    st.close();
                }
                catch(SQLException e){ }
            }
            if(myConnection != null){
                try{
                    myConnection.close();
                }
                catch(SQLException e){ }
            }
        }
        return word;
    }

    public static void insertWinner(Player winner, String word){
        try{

            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanged_game","root","");
            String query = "INSERT INTO winners (winner_name,word,date ) VALUES (?,?,?);";
            PreparedStatement myStatement2 = myConnection.prepareStatement(query);


            myStatement2.setString(1,winner.getPlayerName());
            myStatement2.setString(2,word);

            java.util.Date date = new java.util.Date();
            Date sqlDate = new java.sql.Date(date.getTime());

            myStatement2.setDate(3,sqlDate);

            myStatement2.execute();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            if(myConnection != null){
                try{
                    myConnection.close();
                }
                catch(SQLException e){ }
            }
        }
    }
}

