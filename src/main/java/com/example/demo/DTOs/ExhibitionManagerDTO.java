package com.example.demo.DTOs;

public class ExhibitionManagerDTO {
    private Long exhibitionManagerID;
    private String name;
    private String surname;
    private String username;

    private String errorDuringLogin;

    public ExhibitionManagerDTO() {
    }

    public ExhibitionManagerDTO(Long exhibitionManagerID, String name, String surname, String username) {
        this.exhibitionManagerID = exhibitionManagerID;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public Long getExhibitionManagerID() {
        return exhibitionManagerID;
    }

    public void setExhibitionManagerID(Long exhibitionManagerID) {
        this.exhibitionManagerID = exhibitionManagerID;
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
