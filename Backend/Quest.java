package Simulado_EngDeSoftware.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Quest {
    
    Scanner sc = new Scanner(System.in);
    String sql = new String();
    Mysqlconnect db2 = new Mysqlconnect();


    public void InserirQuest() throws SQLException{

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

            String peso = new String(scn.nextLine());
           
         sql = "INSERT INTO `questoes` VALUES ('"+codi+"', 'pergunta', 'respa', 'respb', 'respc', 'respd', '"+peso+"', 'correta');"; // comando direto no banco
        
         db1.ExecuteQ(sql);

        db1.Closedatabase();
        scn.close();

       


    }

    public void Buscarquest(){



    }
}
