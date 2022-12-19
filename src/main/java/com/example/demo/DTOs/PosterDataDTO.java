package com.example.demo.DTOs;

import com.example.demo.model.Student;

public class PosterDataDTO {
    private String imageURL;
    private String posterStatus;
    private Long studentID;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPosterStatus() {
        return posterStatus;
    }

    public void setPosterStatus(String posterStatus) {
        this.posterStatus = posterStatus;
    }

    public PosterDataDTO(String imageURL, String posterStatus, Long studentID) {
        this.imageURL = imageURL;
        this.posterStatus = posterStatus;
        this.studentID = studentID;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "PosterDataDTO{" +
                "imageURL='" + imageURL + '\'' +
                ", posterStatus='" + posterStatus + '\'' +
                '}';
    }
}
