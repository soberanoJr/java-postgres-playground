package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppDb {
    public static void main(String[] args) {
        Statement statement = null;

        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
            System.err.println(" Não foi possível carregar a biblioteca de acesso ao banco de dados.");
            System.err.println(e.getMessage());
        }

        try {
            var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "");
            statement = conn.createStatement();
            var result = statement.executeQuery("SELECT * FROM ESTADO");

            System.out.println("Conectado ao banco de dados.");
            
            while (result.next())
                // System.out.printf("Id: %d | Nome: %s | UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
                System.out.printf("UF: %s | %s\n", result.getString("uf"), result.getString("nome"));

        } catch (SQLException e) {
            // e.printStackTrace();
            if (statement == null)
                System.err.println("Não foi possível conectar ao banco de dados. " + e.getMessage());
            else
                System.err.println("Não foi possível executar a consulta ao banco de dados. "+ e.getMessage());
        }
    }
}