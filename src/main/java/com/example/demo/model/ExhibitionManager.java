package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EXHIBITION_MANAGER")
public class ExhibitionManager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exhibition_manager_ID")
    private Long exhibitionManagerID;

    @Column(
            length = 50
    )
    private String name;

    @Column(
            length = 50
    )
    private String surname;

    @Column(
            length = 100
    )
    private String password;

    @Column(
            length = 50,
            unique = true
    )
    private String username;

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

    public ExhibitionManager() {
    }

    public ExhibitionManager(String name, String surname, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
    }
}
