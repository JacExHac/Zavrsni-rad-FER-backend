package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NOTIFICATION")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notification_ID")
    private Long notificationID;

    @Column(
            length = 50,
            nullable = false
    )
    private String title;

    @Column(
            length = 250,
            nullable = false
    )
    private String messageBody;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stuslu_member_id", nullable = false)
    private StudentServiceMember studentServiceMember;

    public Notification() {
    }

    public Notification(String title, String messageBody, StudentServiceMember studentServiceMember) {
        this.title = title;
        this.messageBody = messageBody;
        this.studentServiceMember = studentServiceMember;
    }

    public Long getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(Long notificationID) {
        this.notificationID = notificationID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public StudentServiceMember getStudentServiceMember() {
        return studentServiceMember;
    }

    public void setStudentServiceMember(StudentServiceMember studentServiceMember) {
        this.studentServiceMember = studentServiceMember;
    }
}
