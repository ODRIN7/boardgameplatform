package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.domain.notification.Notification;
import hu.odrin7.bga.domain.notification.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void fillData() {
        List<Notification> notifications = this.getNotifications();
        if (notifications.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                Notification post = new Notification("Sample message post title #" + i, "Sample message post content #" + i);
                notificationRepository.save(post);
                log.warn(post.toString());
            }
        }
    }

    @Override
    public List<Notification> getNotifications() {
        return Lists.newArrayList(notificationRepository.findAll());
    }

    @Override
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification deleteNotification(Long notificationId) {
        Notification notification = notificationRepository.findOne(notificationId);
        if (notification != null) {
            notificationRepository.delete(notification);
        }
        return notification;
    }
}
