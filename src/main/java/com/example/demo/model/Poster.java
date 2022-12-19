package com.example.demo.model;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.Optional;



@Entity
@Table(name = "POSTER")
public class Poster implements Serializable{


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "image_URL",
            updatable = false
    )
    private String imageURL;

    @Column(
            name = "poster_status",
            columnDefinition = "varchar(50) default 'pending'"
    )
    private String posterStatus;


    @OneToOne()
    @JoinColumn(name = "student_id")
    private Student student;

    public Poster() {

    }


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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Poster(String posterStatus, Student student) {
        this.posterStatus = posterStatus;
        this.student = student;
    }

    public Poster(String imageURL, String posterStatus, Student student) {
        this.imageURL = imageURL;
        this.posterStatus = posterStatus;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "imageURL='" + imageURL + '\'' +
                ", posterStatus='" + posterStatus + '\'' +
                ", student=" + student +
                '}';
    }
}
