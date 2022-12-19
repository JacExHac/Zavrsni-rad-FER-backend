package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "STUDENT_POSTER_REQUEST")
public class StudentPosterRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_poster_request_ID")
    private Long studentPosterRequestID;


    @OneToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;


    @Column(
            columnDefinition = "integer default 0"
    )
    private int numOfChange;

    @Column(length = 300)
    private String managerComment;
    private int lastEditedBy;

    @Column(length = 300)
    private String studentComment;

    public StudentPosterRequest() {
    }

    public StudentPosterRequest(Student student, int numOfChange, String managerComment, int lastEditedBy, String studentComment) {
        this.student = student;
        this.numOfChange = numOfChange;
        this.managerComment = managerComment;
        this.lastEditedBy = lastEditedBy;
        this.studentComment = studentComment;
    }



    public Long getStudentPosterRequestID() {
        return studentPosterRequestID;
    }

    public void setStudentPosterRequestID(Long studentPosterRequestID) {
        this.studentPosterRequestID = studentPosterRequestID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    @Override
    public String toString() {
        return "StudentPosterRequest{" +
                "studentPosterRequestID=" + studentPosterRequestID +
                ", student=" + student +
                ", numOfChange=" + numOfChange +
                ", managerComment='" + managerComment + '\'' +
                ", lastEditedBy=" + lastEditedBy +
                ", studentComment='" + studentComment + '\'' +
                '}';
    }
}
