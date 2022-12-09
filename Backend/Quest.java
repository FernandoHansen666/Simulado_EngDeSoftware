package Simulado_EngDeSoftware.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Quest {

    Scanner scn = new Scanner(System.in);
    String sql = new String();
    Mysqlconnect db1 = new Mysqlconnect();
    String correta = new String();
    String pontos = new String();

    public void InserirQuest() throws SQLException {

        db1.Opendatabase();

        sql = "SELECT * FROM questoes;";

        ResultSet rs = db1.Searchdate(sql);

        // java.sql.ResultSetMetaData rsmd = rs.getMetaData();

        int codi = 0;

        while (rs.next()) { // navega linha a linha

            codi = rs.getInt(1); // trabalha na coluna armazenando o ultimo item lido

        }
        System.out.println(codi);
        codi = +1; // soma pra criar ID automatico nas questoes

        System.out.print("Pergunta: ");
        String pergunta = new String(scn.nextLine());
        System.out.print("Resposta A: ");
        String respa = new String(scn.nextLine());
        System.out.print("Resposta B: ");
        String respb = new String(scn.nextLine());
        System.out.print("Resposta C: ");
        String respc = new String(scn.nextLine());
        System.out.print("Resposta D: ");
        String respd = new String(scn.nextLine());
        System.out.print("Peso da Questão (1,2 ou 3): ");
        String peso = new String(scn.nextLine());
        System.out.print("Resposta Correta (A,B,C ou D): ");
        String correta = new String(scn.nextLine());

        sql = "INSERT INTO `questoes` VALUES ('" + codi + "', '" + pergunta + "', '" + respa + "', '" + respb + "', '"
                + respc + "', '" + respd + "', '" + peso + "', '" + correta + "');"; // comando direto no banco

        db1.ExecuteQ(sql);

        db1.Closedatabase();
        scn.close();

    }

    public void Buscartodasquest() throws SQLException {

        sql = "SELECT * FROM questoes;";

        db1.Opendatabase();

        ResultSet rs = db1.Searchdate(sql);

        java.sql.ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("");
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1)
                    System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
            }
            System.out.println("");
        }

        db1.Closedatabase();
        scn.close();

    }

    public void Buscarquest() throws SQLException {

        System.out.print("Digite o ID da questão: ");
        String idquest = new String(scn.nextLine());
        sql = "SELECT * FROM questoes WHERE id= " + idquest + " ;";
        db1.Opendatabase();

        ResultSet rs = db1.Searchdate(sql);

        java.sql.ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("");
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1)
                    System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
            }
            System.out.println("");
        }

        db1.Closedatabase();
        scn.close();

    }

    public void Fazerquest() throws SQLException { // fazer questoes


        db1.Opendatabase();

        System.out.println("Voce deseja simulado (1) ou treino (2) ?");
        Scanner fake = new Scanner(System.in);
        fake.nextInt();
        fake.close();


        Random gerador = new Random();
        int gerar = gerador.nextInt(2);    //  quantidade de questoes cadastradas
          
        

        sql = "SELECT * FROM questoes WHERE id= " + gerar + " ;";
        ResultSet rs = db1.Searchdate(sql);
        java.sql.ResultSetMetaData rsmd = rs.getMetaData();

        
        System.out.println(gerar);
        
        

        System.out.println("");
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1)
                    if (i <= 6) {
                    
                    System.out.println();
                String columnValue = rs.getString(i);
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue);

                                }
                     else if (i == 8) {
                        String columnValue = rs.getString(i);
                                 correta = columnValue;
                                }
                    else if (i == 7) {
                         String columnValue = rs.getString(i);
                                    pontos = columnValue;
                                            }
            }
            System.out.println("");
        }
        System.out.println("Qual é sua resposta: ");
        String resp = scn.nextLine();
        if (resp.equals(correta)) {
            System.out.println("acertou!");
            System.out.println("+"+" "+pontos+" Pontos");
        }
        else{
            System.out.println("ERROU!");
        }

        db1.Closedatabase();
        scn.close();


    }
}
