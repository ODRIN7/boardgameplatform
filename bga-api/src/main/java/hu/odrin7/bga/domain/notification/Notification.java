package hu.odrin7.bga.domain.notification;

import hu.odrin7.bga.domain.user.User;
import org.springframework.data.annotation.Id;

public class Notification {

    @Id
    private String id;
    private User user;
}
