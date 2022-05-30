package com.example.navegacaotelas.model;

public class Student {
    int id;
    String name;
    String register;
    String cpf;


    public Student(){
        this.name = "";
        this.register = "";
        this.cpf = "";
    }

    public Student(String name, String register, String cpf, int id) {
        this.name = name;
        this.register = register;
        this.cpf = cpf;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
