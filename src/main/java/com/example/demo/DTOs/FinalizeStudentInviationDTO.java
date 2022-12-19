package com.example.demo.DTOs;

public class FinalizeStudentInviationDTO {

    private Long studentInvitationID;
    private Long studentID;
    private String studentStatus;

    public FinalizeStudentInviationDTO() {
    }

    public FinalizeStudentInviationDTO(Long studentInvitationID, Long studentID, String studentStatus) {
        this.studentInvitationID = studentInvitationID;
        this.studentID = studentID;
        this.studentStatus = studentStatus;
    }

    public Long getStudentInvitationID() {
        return studentInvitationID;
    }

    public void setStudentInvitationID(Long studentInvitationID) {
        this.studentInvitationID = studentInvitationID;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }
}
