package Simulado_EngDeSoftware.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) throws SQLException {
        Scanner scn = new Scanner(System.in);
        String sql = new String();

        Mysqlconnect db1 = new Mysqlconnect();

        String identify = null;

        System.out.println("------ Escolha alguma das opções ------");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Login");
        System.out.println("3 - Listar cadastros");
        System.out.println("4 - Busca de cadastro");
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

            // Sim, eu sei que desta forma é vulnerável a SQL Injection
            sql = "INSERT INTO `alunos` VALUES ('" + nomeAluno + "', '" + user + "', '" + senha + "', '" + iduser
                    + "', '" + serie + "', '" + idade + "', 0, 0);"; // comando direto no banco

            db1.Opendatabase();
            db1.ExecuteQ(sql);
            db1.Closedatabase();
            scn.close();
        }

        // --------------------------------------------------

        else if (identify.equals("2")) { // ITEM 2

            System.out.println("Digite o user:");
            String userpesq = new String(scn.nextLine());

            sql = "SELECT * FROM alunos WHERE user = '" + userpesq + "';";

            db1.Opendatabase();

            ResultSet rs = db1.Searchdate(sql);

            java.sql.ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("");
            int columnsNumber = rsmd.getColumnCount();
            int validarlog = 0;

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {

                        String columnValue = rs.getString(i);

                        if (columnValue.equals(userpesq)) {
                            validarlog = 1;
                            System.out.println("Senha: ");
                            String passw = new String(scn.nextLine());
                            if (passw.equals(rs.getString(3))) {

                                System.out.println("Logado!");
                                System.out.println(" Olá " + rs.getString(1));

                            } else {
                                System.out.println("Senha Incorreta!");
                            }

                        }
                    }

                }

                System.out.println("");
            }
            if (validarlog == 0) { // aaaaaaaaaaaaaaaaaaaaaaaaaaaa
                System.out.println("User invalido!");
            }
            db1.Closedatabase();
            scn.close();
        }

        // ------------------------------------------------------

        else if (identify.equals("3")) { // ITEM 3

            System.out.println("Listagem Completa:_________");

            sql = "SELECT * FROM alunos;";

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

        // -----------------------------------------------------------

        else if (identify.equals("4")) { // ITEM 4 Teste

            System.out.println("------ Escolha por qual dado deseja buscar ------");
            System.out.println("1 - Nome");
            System.out.println("2 - Usuario");
            System.out.println("3 - Senha");
            System.out.println("4 - Codigo");
            System.out.println("5 - Serie");
            System.out.println("6 - Idade");
            System.out.println("----------------------------------------");

            String escolhabusc = new String(scn.nextLine());

            db1.Opendatabase();

            if (escolhabusc.equals("1")) { // inicio nome-------
                System.out.println("Digite o nome:");

                String dado = new String(scn.nextLine());

                sql = "SELECT * FROM alunos WHERE nome = '" + dado + "';";

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
            } // final nome ------------------------------------------------------
            else if (escolhabusc.equals("2")) { // inicio User-------
                System.out.println("Digite o usuario:");

                String dado = new String(scn.nextLine());

                sql = "SELECT * FROM alunos WHERE user = '" + dado + "';";

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
            } // final user ------------------------------------------------------
            else if (escolhabusc.equals("3")) { // inicio senha-------
                System.out.println("Digite a Senha:");

                String dado = new String(scn.nextLine());

                sql = "SELECT * FROM alunos WHERE senha = '" + dado + "';";

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
            } // final senha ------------------------------------------------------
            else if (escolhabusc.equals("4")) { // inicio Cod-------
                System.out.println("Digite o Codigo:");

                String dado = new String(scn.nextLine());

                sql = "SELECT * FROM alunos WHERE codid = '" + dado + "';";

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
            } // final Cod ------------------------------------------------------
            else if (escolhabusc.equals("5")) { // inicio serie-------
                System.out.println("Digite a Serie:");

                String dado = new String(scn.nextLine());

                sql = "SELECT * FROM alunos WHERE serie = '" + dado + "';";

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
            } // final serie ------------------------------------------------------
            else if (escolhabusc.equals("6")) { // inicio idade-------
                System.out.println("Digite a Idade:");

                String dado = new String(scn.nextLine());

                sql = "SELECT * FROM alunos WHERE idade = '" + dado + "';";

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
            } // final idade ------------------------------------------------------
            else if (!escolhabusc.equals("1") | !escolhabusc.equals("2") | !escolhabusc.equals("3")
                    | !escolhabusc.equals("4") | !escolhabusc.equals("5") | !escolhabusc.equals("6")) {
                System.out.println("escolha invalida!");
            }

            db1.Closedatabase();
            scn.close();
        } else if (identify.equals("0")) {
            System.out.println("Finalizado!");
            System.exit(1);
        }

    }
}