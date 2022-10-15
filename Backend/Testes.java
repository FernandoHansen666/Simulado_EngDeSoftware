package Simulado_EngDeSoftware.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Testes {
    
    public static void main(String[] args) throws SQLException {
        Scanner scn = new Scanner(System.in);
        String sql = new String();

        Mysqlconnect db1 = new Mysqlconnect();

        sql = "SELECT * FROM questoes;";

        db1.Opendatabase();

        ResultSet rs = db1.Searchdate(sql);


        //java.sql.ResultSetMetaData rsmd = rs.getMetaData();
     
        int codi = 0;
        
            while (rs.next()) { // navega linha a linha
                
            codi = rs.getInt(1); // trabalha na coluna armazenando o ultimo item lido
                
            }
            System.out.println(codi); 
            codi = +1; // soma pra criar ID automatico nas questoes
            System.out.println(codi);
           
        
        

        db1.Closedatabase();
        scn.close();
        
        

    }
}
