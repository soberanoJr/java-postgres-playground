package com.example;

public class AppOperadores {
    public static void main(String[] args) {
        double m = 0.25, n = 3.14, o = 5, p = 19, q = 100;

        if (m % n != 0)
            q *= (m + n + o + p);
        else
            q *= (m - n - o - p);

        System.out.println("m: " + m + " | n: " + n + " | o: " + o + " | p: " + p + " | q: " + q);
    }
}
