package com.example.navegacaotelas.model;

public class Student {
    int countId = 0;
    int id;
    String name;
    String register;
    String cpf;


    public Student() {
        this.name = "";
        this.register = "";
        this.cpf = "";
        this.id = countId++;
    }

    public Student(String name, String register, String cpf) {
        this.name = name;
        this.register = register;
        this.cpf = cpf;
        this.id = countId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Identificador: " + id + "\nNome: " + name + "\nMatrícula: " + register + "\nCPF: " + cpf;
    }
}
