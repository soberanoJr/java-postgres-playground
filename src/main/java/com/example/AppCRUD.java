package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class AppCRUD {
    // .env
    private static final String JBDC_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USERNAME = "gitpod";
    private static final String PASSWORD = "";
    
    public static void main(String[] args) {
        new AppCRUD();
    }

    public AppCRUD(){
        try (var conn = getConnection()){
            var marca = new Marca();
            marca.setId(3L);
            var produto = new Produto();
            produto.setId(208L);
            produto.setMarca(marca);
            produto.setNome("Coiseitor Tabajara Plus a Mais");
            produto.setValor(2999.99);

            //inserirProduto(conn, produto); 
            //alterarProduto(conn, produto); 
            //excluirProduto(conn, 211L);
            listarDados(conn, "produto");

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados. " + e.getMessage());
        }
    }

    // DELETE  
    private void excluirProduto(Connection conn, long id) {
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

    // CREATE 
    private void inserirProduto(Connection conn, Produto produto) {
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

    // UPDATE
    private void alterarProduto(Connection conn, Produto produto) {
        var sql = "UPDATE produto SET nome = ?, marca_id = ?, valor = ? WHERE id = ?";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao alteração do produto." + e.getMessage());
        }
    }

    // READ  
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

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JBDC_URL, USERNAME, PASSWORD);
    }
    
}
