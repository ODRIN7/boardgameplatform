package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.notification.Notification;
import hu.odrin7.bga.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostConstruct
    public void fillData() {
        notificationService.fillData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Notification> getNotifications() {
        return notificationService.getNotifications();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Notification saveNotification(@RequestBody Notification notification) {
        return notificationService.saveNotification(notification);
    }

    @RequestMapping(value = "/{notificationId}", method = RequestMethod.DELETE)
    public Notification deleteNotification(@PathVariable("notificationId") Long notificationId) {
        return notificationService.deleteNotification(notificationId);
    }
}
