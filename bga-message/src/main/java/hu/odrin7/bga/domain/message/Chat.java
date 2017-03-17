package hu.odrin7.bga.domain.message;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "chats")
public class Chat {

    @Id
    private long id;
    private String title;
    private long gameId;
    private List<String> connectedUser;
    private List<Message> messages;

    private Chat() {
    }

    private Chat(Long id, String title, long gameId, String createdUser) {
        this.title = title;
        this.gameId = gameId;
        this.id = id;
        init(createdUser);
    }

    private void init(String createdUser) {
        this.connectedUser = new ArrayList<>();
        this.messages = new ArrayList<>();
        connect(createdUser);
    }

    public static Chat create(Long id, String title, long gameId, String createdUser) {
        return new Chat(id, title, gameId, createdUser);
    }

    public boolean connect(String user) {
        return connectedUser.add(user);
    }

    public boolean disconnect(String user) {
        return connectedUser.remove(user);
    }

    public void write(Message message) {
        messages.add(message);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getGameId() {
        return gameId;
    }

    public List<String> getConnectedUser() {
        return connectedUser;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public void setConnectedUser(List<String> connectedUser) {
        this.connectedUser = connectedUser;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("id", id)
            .add("title", title)
            .add("gameId", gameId)
            .add("connectedUser", connectedUser)
            .add("messages", messages)
            .toString();
    }
}
