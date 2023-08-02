package com.example.sigga;

public class Person {

    private String name;
    private String surname;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(name).append('\n');
        sb.append("Sobrenome: ").append(surname).append('\n');
        sb.append("Email: ").append(email).append('\n');
        sb.append("Senha: ").append(password).append('\n');
        return sb.toString();
    }
}
