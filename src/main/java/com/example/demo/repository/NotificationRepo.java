package com.example.demo.repository;

import com.example.demo.model.Notification;
import com.example.demo.model.StudentServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
    List<Notification> findAllByStudentServiceMember(StudentServiceMember studentServiceMember);

    List<Notification> findAllByOrderByNotificationIDDesc();

}
