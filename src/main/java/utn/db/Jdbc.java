package utn.db;
import utn.model.Word;

import java.sql.Connection; // no me reconoce Connection por eso uso java.sql.*
import java.sql.*;



public class Jdbc {


    public static Word getWord(){
        Word word = null;
        Connection myConnection = null;
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
}

