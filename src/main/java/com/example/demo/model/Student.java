package com.example.demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "student_ID",
            updatable = false
    )
    private Long studentID;

    @Column(
            name = "name",
            nullable = false,
            length = 50
    )
    private String name;

    @Column(
            name = "surname",
            nullable = false,
            length = 50
    )
    private String surname;

    @Column(
            name = "JMBAG",
            nullable = false,
            length = 10,
            unique = true
    )
    private String JMBAG;

    @Column(
            name = "student_status",
            nullable = false,
            length = 50,
            columnDefinition = "varchar(50) default 'created'"
    )
    private String studentStatus;

    @Column(
            name = "password",
            nullable = false,
            length = 200
    )
    private String password;

    @Column(
            name = "username",
            nullable = false,
            length = 50,
            unique = true
    )
    private String username;

    public Student(String name, String surname, String JMBAG, String studentStatus, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.JMBAG = JMBAG;
        this.studentStatus = studentStatus;
        this.password = password;
        this.username = username;
    }

    public Student() {

    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long id) {
        this.studentID = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", JMBAG='" + JMBAG + '\'' +
                ", studentStatus='" + studentStatus + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}
