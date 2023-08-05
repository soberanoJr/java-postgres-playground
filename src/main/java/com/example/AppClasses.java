package com.example;

public class AppClasses {
    public static void main(String[] args) {
        Cliente alice = new Cliente("Alice", 'F', 1979, 17155.50);
        Cliente bob = new Cliente("Bob", 'M', 1983, 11943.57);
        Cliente charlie = new Cliente("Charlie", 'M', 1981, 13887.26);

        System.out.println(alice.getNome() + " | " + alice.getSexo() + " | " + alice.getRenda() + " | " + alice.getAnoNascimento());
        System.out.println(bob.getNome() + " | " + bob.getSexo() + " | " + bob.getRenda() + " | " + bob.getAnoNascimento());
        System.out.println(charlie.getNome() + " | " + charlie.getSexo() + " | " + charlie.getRenda() + " | " + charlie.getAnoNascimento());
        }   
}