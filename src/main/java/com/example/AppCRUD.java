package com.example;

import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.dao.ProdutoDAO;
import com.example.model.Marca;
import com.example.model.Produto;
 
public class AppCRUD {
    public static void main(String[] args) {
        new AppCRUD();
    }

    public AppCRUD(){
        try (var conn = ConnectionManager.getConnection()){
            var marca = new Marca();
            marca.setId(1L);

            var produto = new Produto();
            produto.setId(206L);
            produto.setMarca(marca);
            produto.setNome("Coiseitor Tabajara Plus a Mais");
            produto.setValor(2999.99);
            
            var produtoDAO = new ProdutoDAO(conn);
            produtoDAO.alterar(produto);
            produtoDAO.excluir(207L);
            
            produtoDAO.listar("produto");

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados. " + e.getMessage());
        }
    }    
}
