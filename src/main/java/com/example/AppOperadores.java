package com.example;

import java.util.Scanner;

public class AppOperadores {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ano: ");
            cliente.setAnoNascimento(scanner.nextInt());
            boolean nasceuNosAnos80 = cliente.getAnoNascimento() >= 1980 && cliente.getAnoNascimento() < 1990;

            if (nasceuNosAnos80)
                System.out.println("Nasceu nos anos 80");
            else if (!nasceuNosAnos80 && cliente.getAnoNascimento() < 1980)
                System.out.println("Nasceu antes de 1980");
            else
                System.out.println("Nasceu depois de 1980");
        }

        double m = 0.25, n = 3.14, o = 5, p = 19, q = -100;

        if (m % n != 0)
            q *= (m + n + o + p);
        else
            q *= (m - n - o - p);

        System.out.println("m: " + m + " | n: " + n + " | o: " + o + " | p: " + p + " | q: " + q);
    }
}

