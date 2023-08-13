package com.example;

// import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Cliente;

public class AppListas {
    public static void main(String[] args) {
        // Cliente[] vetorClientes = new Cliente[5];
        List<Cliente> listaClientes = new LinkedList<>(); // ArrayList<>()

        var cliente1 = new Cliente("Alice", 'F', 1980, 15478.52);
        var cliente2 = new Cliente("Bob", 'M', 1979, 12734.28);
        var cliente3 = new Cliente("Charlie", 'M', 1980, 14980.17);

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        System.out.println(listaClientes);
        System.out.println("Quantidade: " + listaClientes.size());

        listaClientes.remove(1);

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }

        System.out.println("Quantidade: " + listaClientes.size());

    }
}