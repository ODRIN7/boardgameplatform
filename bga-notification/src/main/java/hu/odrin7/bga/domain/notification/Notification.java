package hu.odrin7.bga.domain.notification;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;
    private String content;

    public Notification() {
    }

    public Notification(String id, String content) {
        this.id = id;
        this.content = content;
    }


}
