package Simulado_EngDeSoftware.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Result;

public class Aplic {
    
   
    
    public static void main(String[] args) throws SQLException  {
        Scanner scn = new Scanner(System.in);
        String sql = new String();
        
        Mysqlconnect db1 = new Mysqlconnect();

        String identify = null;

        System.out.println("------ Escolha alguma das opções ------");
			System.out.println("1 - Cadastro");
			System.out.println("2 - Login");
			System.out.println("3 - Listar cadastros");
			System.out.println("0 - Finalizar programa");
			System.out.println("----------------------------------------");

        identify = scn.nextLine(); // b.o
        

        if (identify.equals("1")) { // ITEM 1
                  

        System.out.print("Nome: ");
        String nomeAluno = new String(scn.nextLine());
        System.out.print("Usuario: ");
        String user = new String(scn.nextLine());
        System.out.print("Senha: ");
        String senha = new String(scn.nextLine());
        System.out.print("ID: ");
        String iduser = new String(scn.nextLine());
        System.out.print("Serie: ");
        String serie = new String(scn.nextLine());
        System.out.print("Idade: ");
        String idade = new String(scn.nextLine());


        sql = "INSERT INTO `alunos` VALUES ('"+nomeAluno+"', '"+user+"', '"+senha+"', '"+iduser+"', '"+serie+"', '"+idade+"', 0, 0);"; // comando direto no banco


        db1.Opendatabase();
        db1.ExecuteQ(sql);
        db1.Closedatabase();
        scn.close();
        }
        else if (identify.equals("2")) { //ITEM 2
            

            String userpesq = new String(scn.nextLine());
            System.out.println("Digite o user:");

            sql = "SELECT * FROM alunos WHERE user = '"+userpesq+"';";
            
            db1.Opendatabase();
          
            ResultSet rs = db1.Searchdate(sql);

   java.sql.ResultSetMetaData rsmd = rs.getMetaData();

   System.out.println("");
   int columnsNumber = rsmd.getColumnCount();
   while (rs.next()) {
       for (int i = 1; i <= columnsNumber; i++) {
           if (i > 1) System.out.print(",  ");
           String columnValue = rs.getString(i);
           System.out.print(rsmd.getColumnName(i) + ": " + columnValue );
       }
       System.out.println("");
   }

            db1.Closedatabase();
            scn.close();
        }
        else if (identify.equals("3")) { //ITEM 3
            

            String userpesq = new String(scn.nextLine());
            System.out.println("Digite o user:");

            sql = "SELECT * FROM alunos;";
            
            db1.Opendatabase();
          
            ResultSet rs = db1.Searchdate(sql);

   java.sql.ResultSetMetaData rsmd = rs.getMetaData();

   System.out.println("");
   int columnsNumber = rsmd.getColumnCount();
   while (rs.next()) {
       for (int i = 1; i <= columnsNumber; i++) {
           if (i > 1) System.out.print(",  ");
           String columnValue = rs.getString(i);
           System.out.print(rsmd.getColumnName(i) + ": " + columnValue );
       }
       System.out.println("");
   }

            db1.Closedatabase();
            scn.close();
        }

       
      
        
    }
}
