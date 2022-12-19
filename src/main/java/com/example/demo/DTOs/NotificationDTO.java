package com.example.demo.DTOs;

public class NotificationDTO {
    private Long notificationID;
    private String title;
    private String messageBody;
    private String messageAuthor;
    private String errorMessage;

    private Long stusluMemberID;

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

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public NotificationDTO() {
    }

    public NotificationDTO(Long notificationID, String title, String messageBody, String messageAuthor) {
        this.notificationID = notificationID;
        this.title = title;
        this.messageBody = messageBody;
        this.messageAuthor = messageAuthor;
    }

    public NotificationDTO(Long notificationID, String title, String messageBody, String messageAuthor, Long stusluMemberID) {
        this.notificationID = notificationID;
        this.title = title;
        this.messageBody = messageBody;
        this.messageAuthor = messageAuthor;
        this.stusluMemberID = stusluMemberID;
    }

    public Long getStusluMemberID() {
        return stusluMemberID;
    }

    public void setStusluMemberID(Long stusluMemberID) {
        this.stusluMemberID = stusluMemberID;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
