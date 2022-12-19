package com.example.demo.DTOs;

public class StudentDataDTO {
    private Long studentID;
    private String name;
    private String surname;
    private String JMBAG;
    private String studentStatus;
    private String username;
    private String posterURL;
    private String posterStatus;

    private boolean hasStudentPosterRequest;

    private String errorDuringLogin;

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
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

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getPosterStatus() {
        return posterStatus;
    }

    public void setPosterStatus(String posterStatus) {
        this.posterStatus = posterStatus;
    }

    public StudentDataDTO() {
    }

    public StudentDataDTO(Long studentID, String name, String surname, String JMBAG, String studentStatus, String username, String posterURL, String posterStatus) {
        this.studentID = studentID;
        this.name = name;
        this.surname = surname;
        this.JMBAG = JMBAG;
        this.studentStatus = studentStatus;
        this.username = username;
        this.posterURL = posterURL;
        this.posterStatus = posterStatus;
    }

    public StudentDataDTO(Long studentID, String name, String surname, String JMBAG, String studentStatus, String username, String posterStatus) {
        this.studentID = studentID;
        this.name = name;
        this.surname = surname;
        this.JMBAG = JMBAG;
        this.studentStatus = studentStatus;
        this.username = username;
        this.posterStatus = posterStatus;
    }

    public StudentDataDTO(Long studentID, String name, String surname, String JMBAG, String studentStatus, String username) {
        this.studentID = studentID;
        this.name = name;
        this.surname = surname;
        this.JMBAG = JMBAG;
        this.studentStatus = studentStatus;
        this.username = username;
    }

    public String getErrorDuringLogin() {
        return errorDuringLogin;
    }

    public void setErrorDuringLogin(String errorDuringLogin) {
        this.errorDuringLogin = errorDuringLogin;
    }

    @Override
    public String toString() {
        return "StudentDataDTO{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", JMBAG='" + JMBAG + '\'' +
                ", studentStatus='" + studentStatus + '\'' +
                ", username='" + username + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", posterStatus='" + posterStatus + '\'' +
                ", errorDuringLogin='" + errorDuringLogin + '\'' +
                '}';
    }

    public boolean isHasStudentPosterRequest() {
        return hasStudentPosterRequest;
    }

    public void setHasStudentPosterRequest(boolean hasStudentPosterRequest) {
        this.hasStudentPosterRequest = hasStudentPosterRequest;
    }
}
