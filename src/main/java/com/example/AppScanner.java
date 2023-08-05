package com.example;

import java.util.Scanner;

public class AppScanner {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nome: ");
            cliente.setNome(scanner.nextLine());

            System.out.print("Renda: ");
            cliente.setRenda(scanner.nextDouble());

            System.out.print("Ano de Nascimento: ");
            cliente.setAnoNascimento(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Sexo: ");
            char sexo = scanner.nextLine().toUpperCase().charAt(0);
            if (sexo == 'M' || sexo == 'F'){
                cliente.setSexo(sexo);
            }
            else System.out.println("?");
        }

        System.out.println(
            "Nome: " + cliente.getNome() + " | " +
            "Sexo: " + cliente.getSexo() + " | " +
            "Renda: " + cliente.getRenda() + " | " + 
            "Ano de Nascimento: " + cliente.getAnoNascimento() 
        );
    }
}