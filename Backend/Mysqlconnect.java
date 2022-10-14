package Simulado_EngDeSoftware.Backend;
import java.sql.*;

public class Mysqlconnect {
    
    public static String url = "jdbc:mysql://localhost:3306/OGF";
    public static String user = "root";
    public static String senha = "";

    private Connection dbcon = null;
    private Statement sqlmg = null;
    //private ResultSet resultsql = null;


    public void Opendatabase (){

        try {
            dbcon = DriverManager.getConnection(url, user, senha);
            System.out.println("Sql Aberto!: " + url);
            sqlmg = dbcon.createStatement();

        } catch (Exception Error){

            System.out.println("Falha ao abrir Sql: " +Error.getMessage());
        }
    }

    public void Closedatabase() throws SQLException { // fecha o banco

        sqlmg.close();
        dbcon.close();
    }

    public int ExecuteQ(String sql){ 

        try {
       return sqlmg.executeUpdate(sql);


        }
        catch (Exception Error) {

            System.out.println("errorrr" + Error.getMessage());
        }
        return -1;
    }

    public ResultSet Searchdate(String sql) throws SQLException{ //retorna os daDOS

       
          return sqlmg.executeQuery(sql);

          
        
    }
    
}
