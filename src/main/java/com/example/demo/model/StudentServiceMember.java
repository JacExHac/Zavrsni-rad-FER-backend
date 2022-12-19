package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT_SERVICE_MEMBER")
public class StudentServiceMember implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "stuslu_member_ID",
            updatable = false
    )
    private Long stusluMemberID;

    @Column(
            nullable = false,
            length = 50
    )
    private String name;

    @Column(
            nullable = false,
            length = 50
    )
    private String surname;

    @Column(
            nullable = false,
            length = 200
    )
    private String password;

    @Column(
            nullable = false,
            unique = true,
            length = 50
    )
    private String username;

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

    public StudentServiceMember(String name, String surname, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
    }

    public StudentServiceMember() {

    }
}
