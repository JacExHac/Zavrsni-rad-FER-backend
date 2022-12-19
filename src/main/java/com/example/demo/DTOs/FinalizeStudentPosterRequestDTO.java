package com.example.demo.DTOs;

public class FinalizeStudentPosterRequestDTO {

    private Long studentID;
    private String posterStatus;

    public FinalizeStudentPosterRequestDTO(Long studentID, String posterStatus) {
        this.studentID = studentID;
        this.posterStatus = posterStatus;
    }

    public FinalizeStudentPosterRequestDTO() {
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getPosterStatus() {
        return posterStatus;
    }

    public void setPosterStatus(String posterStatus) {
        this.posterStatus = posterStatus;
    }
}
