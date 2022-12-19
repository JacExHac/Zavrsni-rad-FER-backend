package com.example.demo.DTOs;

public class StudentServiceMemberDTO {
    private Long stusluMemberID;
    private String name;
    private String surname;
    private String username;
    private String errorDuringLogin;

    public StudentServiceMemberDTO() {
    }

    public StudentServiceMemberDTO(Long stusluMemberID, String name, String surname, String username) {
        this.stusluMemberID = stusluMemberID;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public Long getStusluMemberID() {
        return stusluMemberID;
    }

    public void setStusluMemberID(Long stusluMemberID) {
        this.stusluMemberID = stusluMemberID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getErrorDuringLogin() {
        return errorDuringLogin;
    }

    public void setErrorDuringLogin(String errorDuringLogin) {
        this.errorDuringLogin = errorDuringLogin;
    }
}
