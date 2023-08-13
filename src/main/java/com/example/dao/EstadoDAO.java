package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class EstadoDAO {
    private Connection conn;

    public EstadoDAO(Connection conn) {
        this.conn = conn;
    }

    public void listar() {
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery("SELECT * FROM estado");
            
            while (result.next())
                System.out.printf(" %10s | %s\n", result.getString("uf"), result.getString("nome"));
            System.out.println("");
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados. " + e.getMessage());
        }
    }

    public void localizar(String uf) {
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

}
