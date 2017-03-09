package hu.odrin7.bga.domain.message;

import hu.odrin7.bga.domain.game.Game;
import hu.odrin7.bga.domain.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "chats")
public class Chat {

    public static long seq = 10000L;
    @Id
    private long id;
    private String title;
    private Game gameId;
    private List<User> connectedUser;
    private List<Message> messages;

    private Chat() {
    }

    private Chat(String title, Game gameId, User createdUser) {
        this.title = title;
        this.gameId = gameId;
        this.connectedUser = connectedUser;
        this.messages = messages;
        init();
    }

    private void init() {
        this.id = seq;
        this.connectedUser = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public static Chat create(String title, Game gameId, User createdUser) {
        return new Chat(title, gameId, createdUser);
    }

    public boolean connect(User user) {
        return connectedUser.add(user);
    }

    public boolean disconnect(User user) {
        return connectedUser.remove(user);
    }

    public void write(String title, String content, User user) {
        Message.create(title, content, user.getUsername(), connectedUser);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Game getGameId() {
        return gameId;
    }

    public List<User> getConnectedUser() {
        return connectedUser;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
