package com.example;

import java.time.LocalDate;

import com.example.model.Cidadao;

public class AppEleitor {
    public static void main(String[] args) {
        var cidadao = new Cidadao();
        cidadao.setDataNascimento(LocalDate.of(2004, 12, 3));
        System.out.println(LocalDate.now());
        System.out.println(cidadao.getDataNascimento());
        System.out.println(cidadao.idade());
        System.out.println(cidadao.eleitor());
    }
}
