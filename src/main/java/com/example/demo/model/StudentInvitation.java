package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT_INVITATION")
public class StudentInvitation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_invitation_ID")
    private Long studentInvitationID;


    private String studentResponse;


    @Column(name="student_text",length = 300)
    private String studentText;

    @OneToOne(optional = false)
    @JoinColumn(name = "student_ID", nullable = false)
    private Student student;

    @ManyToOne( optional = false)
    @JoinColumn(name = "stuslu_member_id", nullable = false)
    private StudentServiceMember studentServiceMember;

    public StudentInvitation() {
    }

    public StudentInvitation(String studentResponse, String studentText, Student student, StudentServiceMember studentServiceMember) {
        this.studentResponse = studentResponse;
        this.studentText = studentText;
        this.student = student;
        this.studentServiceMember = studentServiceMember;
    }

    public StudentInvitation(Student student, StudentServiceMember studentServiceMember) {
        this.student = student;
        this.studentServiceMember = studentServiceMember;
    }

    public Long getStudentInvitationID() {
        return studentInvitationID;
    }

    public void setStudentInvitationID(Long studentInvitationID) {
        this.studentInvitationID = studentInvitationID;
    }

    public String getStudentResponse() {
        return studentResponse;
    }

    public void setStudentResponse(String studentResponse) {
        this.studentResponse = studentResponse;
    }

    public String getStudentText() {
        return studentText;
    }

    public void setStudentText(String studentText) {
        this.studentText = studentText;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentServiceMember getStudentServiceMember() {
        return studentServiceMember;
    }

    public void setStudentServiceMember(StudentServiceMember studentServiceMember) {
        this.studentServiceMember = studentServiceMember;
    }
}
