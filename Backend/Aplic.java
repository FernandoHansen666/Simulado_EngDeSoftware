package Simulado_EngDeSoftware.Backend;

import java.sql.SQLException;
import java.util.Scanner;

public class Aplic {
    
   
    
    public static void main(String[] args) throws SQLException  {
        Scanner scn = new Scanner(System.in);
        String sql = new String();
        
        Mysqlconnect db1 = new Mysqlconnect();

        int identify = 0;

        System.out.println("------ Escolha alguma das opções ------");
			System.out.println("1 - Cadastro");
			System.out.println("2 - Login");
			System.out.println("3 - Listar cadastros");
			System.out.println("0 - Finalizar programa");
			System.out.println("----------------------------------------");

            identify = scn.nextInt();
            int nada = 0;

        switch (identify) {      
        
        case 1:

        nada = scn.nextInt();


        System.out.println("Nome: ");
        String nomeAluno = new String(scn.nextLine());
        System.out.println("Usuario: ");
        String user = new String(scn.nextLine());
        System.out.println("Senha: ");
        String senha = new String(scn.nextLine());
        System.out.println("ID: ");
        String iduser = new String(scn.nextLine());
        System.out.println("Serie: ");
        String serie = new String(scn.nextLine());
        System.out.println("Idade: ");
        String idade = new String(scn.nextLine());


        sql = "INSERT INTO `alunos` VALUES ('"+nomeAluno+"', '"+user+"', '"+senha+"', '"+iduser+"', '"+serie+"', '"+idade+"', 0, 0);"; // comando direto no banco

        db1.Opendatabase();
        db1.ExecuteQ(sql);
        db1.Closedatabase();
        scn.close();
       
        case 2:
            System.out.println("digite o login: ");
            String buscalgn = new String(scn.nextLine());
            sql = "SELECT * FROM alunos WHERE user = 'nayra123';";
            db1.ExecuteQ(sql);
            db1.Closedatabase();
            scn.close(); 
            
        }

    }
}
