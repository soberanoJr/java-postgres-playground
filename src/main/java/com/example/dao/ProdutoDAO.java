package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    // CREATE 
    public void inserir(Produto produto) {
        var sql = "INSERT INTO produto (nome, marca_id, valor) VALUES (?, ?, ?)";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto." + e.getMessage());
        }
    }

    // READ  
    public void listar(String tabela) {
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

    // UPDATE
    public void alterar(Produto produto) {
        var sql = "UPDATE produto SET nome = ?, marca_id = ?, valor = ? WHERE id = ?";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao alterar produto." + e.getMessage());
        }
    }

    // DELETE  
    public void excluir(long id) {
        var sql = "DELETE FROM produto WHERE id = ?";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);
            if(statement.executeUpdate() == 1)
                System.out.println("Excluído");
            else
                System.out.println("Não excluído");
        } catch (SQLException e) {
            System.err.println("Erro ao excluir produto." + e.getMessage());
        }
    }

}
