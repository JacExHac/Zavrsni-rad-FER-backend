package com.example.demo.DTOs;

public class StudentPosterRequestDTO {

    private Long studentID;
    private String JMBAG;
    private int numOfChange;
    private String managerComment;
    private int lastEditedBy;
    private String studentComment;

    private String posterURL;

    private String name;
    private String surname;

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getJMBAG() {
        return JMBAG;
    }

    public void setJMBAG(String JMBAG) {
        this.JMBAG = JMBAG;
    }

    public int getNumOfChange() {
        return numOfChange;
    }

    public void setNumOfChange(int numOfChange) {
        this.numOfChange = numOfChange;
    }

    public String getManagerComment() {
        return managerComment;
    }

    public void setManagerComment(String managerComment) {
        this.managerComment = managerComment;
    }

    public int getLastEditedBy() {
        return lastEditedBy;
    }

    public void setLastEditedBy(int lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
    }

    public String getStudentComment() {
        return studentComment;
    }

    public void setStudentComment(String studentComment) {
        this.studentComment = studentComment;
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

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public StudentPosterRequestDTO(Long studentID, String JMBAG, int numOfChange, String managerComment, int lastEditedBy, String studentComment) {
        this.studentID = studentID;
        this.JMBAG = JMBAG;
        this.numOfChange = numOfChange;
        this.managerComment = managerComment;
        this.lastEditedBy = lastEditedBy;
        this.studentComment = studentComment;
    }

    public StudentPosterRequestDTO(String JMBAG, int numOfChange, String managerComment, int lastEditedBy, String studentComment) {
        this.JMBAG = JMBAG;
        this.numOfChange = numOfChange;
        this.managerComment = managerComment;
        this.lastEditedBy = lastEditedBy;
        this.studentComment = studentComment;
    }

    public StudentPosterRequestDTO() {
    }

    public StudentPosterRequestDTO(Long studentID, String JMBAG, int numOfChange, String managerComment, int lastEditedBy, String studentComment, String posterURL) {
        this.studentID = studentID;
        this.JMBAG = JMBAG;
        this.numOfChange = numOfChange;
        this.managerComment = managerComment;
        this.lastEditedBy = lastEditedBy;
        this.studentComment = studentComment;
        this.posterURL = posterURL;
    }

    public StudentPosterRequestDTO(Long studentID, String JMBAG, String name, String surname, int numOfChange, String managerComment, int lastEditedBy, String studentComment, String posterURL) {
        this.studentID = studentID;
        this.JMBAG = JMBAG;
        this.name = name;
        this.surname = surname;
        this.numOfChange = numOfChange;
        this.managerComment = managerComment;
        this.lastEditedBy = lastEditedBy;
        this.studentComment = studentComment;
        this.posterURL = posterURL;
    }

    @Override
    public String toString() {
        return "StudentPosterRequestDTO{" +
                "studentID=" + studentID +
                ", JMBAG='" + JMBAG + '\'' +
                ", numOfChange=" + numOfChange +
                ", managerComment='" + managerComment + '\'' +
                ", lastEditedBy=" + lastEditedBy +
                ", studentComment='" + studentComment + '\'' +
                ", posterURL='" + posterURL + '\'' +
                '}';
    }
}
