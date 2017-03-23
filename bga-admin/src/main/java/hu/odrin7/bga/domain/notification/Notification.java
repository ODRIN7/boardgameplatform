package hu.odrin7.bga.domain.notification;

import hu.odrin7.bga.domain.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "notifications")
public class Notification {

    @Id
    private long id;
    private String description;
    private LocalDateTime creationTime;
    private User user;

    public Notification() {
    }

    public Notification(long id, String description, LocalDateTime creationTime, User user) {
        this.id = id;
        this.description = description;
        this.creationTime = creationTime;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
