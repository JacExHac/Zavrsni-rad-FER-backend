package com.example.demo.DTOs;

public class PersonTBAByAdminDTO {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String JMBAG;
    private String role;
    private String errorMessage;

    public PersonTBAByAdminDTO() {
    }

    public PersonTBAByAdminDTO(String username, String password, String name, String surname, String JMBAG, String role, String errorMessage) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.JMBAG = JMBAG;
        this.role = role;
        this.errorMessage = errorMessage;
    }

    public PersonTBAByAdminDTO(String username, String password, String name, String surname, String role, String errorMessage) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.errorMessage = errorMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getJMBAG() {
        return JMBAG;
    }

    public void setJMBAG(String JMBAG) {
        this.JMBAG = JMBAG;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "PersonTBAByAdminDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", JMBAG='" + JMBAG + '\'' +
                ", role='" + role + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
