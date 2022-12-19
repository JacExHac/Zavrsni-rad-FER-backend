package com.example.demo.DTOs;

public class StudentInvitationDTO {
    private Long studentInvitationID;
    private String studentResponse;
    private String studentText;
    private Long studentID;
    private Long stusluMemberID;
    private String JMBAG;

    public StudentInvitationDTO(Long studentInvitationID, String studentResponse, String studentText, Long studentID, Long stusluMemberID) {
        this.studentInvitationID = studentInvitationID;
        this.studentResponse = studentResponse;
        this.studentText = studentText;
        this.studentID = studentID;
        this.stusluMemberID = stusluMemberID;
    }

    public StudentInvitationDTO() {
    }

    public StudentInvitationDTO(Long studentInvitationID, String studentResponse, String studentText, Long studentID, Long stusluMemberID, String JMBAG) {
        this.studentInvitationID = studentInvitationID;
        this.studentResponse = studentResponse;
        this.studentText = studentText;
        this.studentID = studentID;
        this.stusluMemberID = stusluMemberID;
        this.JMBAG = JMBAG;
    }

    public StudentInvitationDTO(Long studentID, Long stusluMemberID) {
        this.studentID = studentID;
        this.stusluMemberID = stusluMemberID;
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

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public Long getStusluMemberID() {
        return stusluMemberID;
    }

    public void setStusluMemberID(Long stusluMemberID) {
        this.stusluMemberID = stusluMemberID;
    }

    public String getJMBAG() {
        return JMBAG;
    }

    public void setJMBAG(String JMBAG) {
        this.JMBAG = JMBAG;
    }
}
