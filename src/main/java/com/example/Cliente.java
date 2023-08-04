package com.example;

public class Cliente {
    private String nome;
    private char sexo;
    private int anoNascimento;
    private double renda;

    public Cliente(String nome, char sexo, int anoNascimento, double renda){
        this.nome = nome;
        this.sexo = sexo;
        this.anoNascimento = anoNascimento;
        this.renda = renda;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name.trim();
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public double getRenda(){
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    /* public void setRenda(double renda){
        if(renda >= 0)
           this.renda = renda;
        else System.out.println("Renda < 0?");
    } */
}