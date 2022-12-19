package com.example.demo.DTOs;

public class AdministratorDataDTO {

    private Long administratorID;
    private String username;

    private String errorDuringLogin;

    public AdministratorDataDTO(Long administratorID, String username) {
        this.administratorID = administratorID;
        this.username = username;
    }

    public Long getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AdministratorDataDTO() {
    }

    public String getErrorDuringLogin() {
        return errorDuringLogin;
    }

    public void setErrorDuringLogin(String errorDuringLogin) {
        this.errorDuringLogin = errorDuringLogin;
    }
}
