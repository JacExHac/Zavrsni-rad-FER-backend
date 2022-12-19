package com.example.demo.DTOs;

public class SendInvitationAnswerDTO {

    private Long studentInvitationID;
    private String studentResponse;
    private String studentText;

    public SendInvitationAnswerDTO(Long studentInvitationID, String studentResponse, String studentText) {
        this.studentInvitationID = studentInvitationID;
        this.studentResponse = studentResponse;
        this.studentText = studentText;
    }

    public SendInvitationAnswerDTO() {
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

    @Override
    public String toString() {
        return "SendInvitationAnswerDTO{" +
                "studentInvitationID=" + studentInvitationID +
                ", studentResponse='" + studentResponse + '\'' +
                ", studentText='" + studentText + '\'' +
                '}';
    }
}
