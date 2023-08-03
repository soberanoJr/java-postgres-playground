package com.example;

import java.util.Arrays;

public class AppTipos {
    public static void main(String[] args) {
        byte byteNumber = 18;
        double doubleNumber = byteNumber;
        char asciiChar = 77;
        char gender = 'M';
        boolean choice = true;
        var number = 1;
        var anotherNumber = 3.14;
        var character = 'a';
        var bool = true;
        byte vector[] = {0, 1, 2, 3};
        char charVector[] = {'a', 'b', 'c'};
        byte arrayOfArrays[][] = { {1, 1, 2}, {3, 5, 8} };
        
        System.out.println("-> byte number: " + byteNumber);
        System.out.println("-> double number: " + doubleNumber);
        System.out.println("-> ascii char: " + asciiChar);
        System.out.println("-> gender: " + gender);
        System.out.println("-> choice: " + choice);
        System.out.println("-> var (number): " + number);
        System.out.println("-> var (another number): " + anotherNumber);
        System.out.println("-> var (character): " + character);
        System.out.println("-> var (bool): " + bool);
        System.out.println("-> vetor: " + Arrays.toString(vector));
        System.out.println("-> vetor (char): " + Arrays.toString(charVector));
        System.out.println("-> vetor[0]: " + vector[0]);
        System.out.println("-> vetor[1]: " + vector[1]);
        System.out.println("-> vetor[2]: " + vector[2]);
        System.out.println("-> vetor[3]: " + vector[3]);
        System.out.println("-> array of arrays: " + 
            Arrays.toString(arrayOfArrays[0]) + 
            Arrays.toString(arrayOfArrays[1])
        );

        double a[][] = new double[4][10];
        for (int i = 0; i < a.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * a[i].length + j + 1;
                System.out.printf("%5.2f ", a[i][j]);
            }
            System.out.println("]");
        }

    }
}
