package com.example.demo.service;

import com.example.demo.DTOs.NotificationDTO;
import com.example.demo.model.Notification;
import com.example.demo.model.StudentServiceMember;
import com.example.demo.repository.NotificationRepo;
import com.example.demo.repository.StudentServiceMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private StudentServiceMemberRepo studentServiceMemberRepo;


    public List<NotificationDTO> getAllNotifications() {
        List<Notification> notificationList = notificationRepo.findAllByOrderByNotificationIDDesc();
        List<NotificationDTO> listOfNotifStudentDTO = new ArrayList<>();

        for(Notification notification : notificationList) {
            listOfNotifStudentDTO.add(new NotificationDTO(
                    notification.getNotificationID(),
                    notification.getTitle(),
                    notification.getMessageBody(),
                    notification.getStudentServiceMember().getName(),
                    notification.getStudentServiceMember().getStusluMemberID()
            ));
        }
        return listOfNotifStudentDTO;
    }

    public void deleteNotification(Long notificationID) {
        Optional<Notification> notificationTBD = notificationRepo.findById(notificationID);

        if(!notificationTBD.isPresent()) {
            return;
        }

        notificationRepo.delete(notificationTBD.get());
    }

    public NotificationDTO addNotification(NotificationDTO notificationDTO) {

        if(notificationDTO.getTitle().length() > 50) {
            notificationDTO.setErrorMessage("Dužina naslova mora biti kraća od 50 znakova");
            return notificationDTO;
        }

        if(notificationDTO.getMessageBody().length() > 250) {
            notificationDTO.setErrorMessage("Dužina tijela poruke mora biti kraća od 250 znakova");
            return notificationDTO;
        }

        Optional<StudentServiceMember> studentServiceMember = studentServiceMemberRepo.findById(notificationDTO.getStusluMemberID());

        if(!studentServiceMember.isPresent()) {
            return null;
        }



        Notification notification = new Notification(
                notificationDTO.getTitle(),
                notificationDTO.getMessageBody(),
                studentServiceMember.get()
        );

        notificationRepo.save(notification);
        return notificationDTO;
    }
}
