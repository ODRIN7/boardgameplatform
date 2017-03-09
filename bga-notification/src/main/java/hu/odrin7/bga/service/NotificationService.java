package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.notification.Notification;

import java.util.List;

public interface NotificationService {

    void fillData();
    List<Notification> getNotifications();
    Notification saveNotification(Notification notification);
    Notification deleteNotification(Long notificationId);
}
