package com.example.showusersonfragment;

public class User {
    private int id;
    private String nome;
    private String apelido;

    public User(int id, String nome, String apelido) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
