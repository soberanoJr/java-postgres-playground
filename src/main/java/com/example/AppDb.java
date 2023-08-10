package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;

public class AppDb {
    private static final String JBDC_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USERNAME = "gitpod";
    private static final String PASSWORD = "";
    //private Connection conn;

    public static void main(String[] args) {
        new AppDb();
    }

    public AppDb(){
        try (var conn = getConnection()){
            //carregarDriverJBDC();
            listarUFs(conn);
            localizarUF(conn, "DF");
            localizarUF(conn, "PR");
            localizarUF(conn, "MA");
            listarDados(conn, "cliente");
            listarDados(conn, "produto");
            listarDados(conn, "cidade");
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados. " + e.getMessage());
        }
    }

    private void listarDados(Connection conn, String tabela) {
            try {
                var statement = conn.createStatement();
                var result = statement.executeQuery("SELECT * FROM " + tabela);
                var metadata = result.getMetaData();
                int cols = metadata.getColumnCount();

                for (int i = 1; i <= cols; i++)
                    System.out.printf("%s | ", metadata.getColumnName(i));
                System.out.println("\n");
                
                while (result.next()){
                    for (int i = 1; i <= cols; i++)
                        System.out.printf("%s | ", result.getString(i));
                    System.out.println();
                }
            } catch (SQLException e) {
                System.err.println("Não foi possível conectar ao banco de dados. " + e.getMessage());
            }
    }

    private void localizarUF(Connection conn, String uf) {
        try {
            // var sql = "SELECT * FROM estado WHERE uf = '" + uf + "'"; Risco de SLQ Injection.
            var sql = "SELECT * FROM estado WHERE uf = ?";
            var statement = conn.prepareStatement(sql);
            //System.out.println(sql);
            statement.setString(1, uf);
            var result = statement.executeQuery();
            if(result.next())
                System.out.printf("%s: %s\n", result.getString("uf"), result.getString("nome"));
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Erro ao executar consulta SQL.");
        }
        
    }

    private void listarUFs(Connection conn) {
        try {
            System.out.println("Conectado ao banco de dados.");

            var statement = conn.createStatement();
            var result = statement.executeQuery("SELECT * FROM estado");
            
            while (result.next())
                // System.out.printf("Id: %d | Nome: %s | UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
                System.out.printf(" %10s | %s\n", result.getString("uf"), result.getString("nome"));
            System.out.println("");
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados. " + e.getMessage());
        }
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JBDC_URL, USERNAME, PASSWORD);
    }

    /* private void carregarDriverJBDC() {
        try {Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
            System.err.println(" Não foi possível carregar a biblioteca de acesso ao banco de dados.");
            System.err.println(e.getMessage());
        }
    } */
}