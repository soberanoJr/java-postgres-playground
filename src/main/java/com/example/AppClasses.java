package com.example;

public class AppClasses {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setRenda(1250.75);
        cliente.setSexo('M');
        cliente.setAnoNascimento(1950);
        System.out.print("-> Renda: R$" + cliente.getRenda());
        System.out.print(" | Sexo: " + cliente.getSexo());
        System.out.println(" | Ano de Nascimento: " + cliente.getAnoNascimento());
    }   
}