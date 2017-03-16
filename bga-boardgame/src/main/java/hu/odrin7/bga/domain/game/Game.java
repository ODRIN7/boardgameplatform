package hu.odrin7.bga.domain.game;

import com.google.common.base.Objects;
import hu.odrin7.bga.domain.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "games")
public class Game {

    @Id
    private long id;
    private long chatId;
    private String title;
    private long boardGameId;
    private List<UserPerGame> userPerGames;
    private Status status;
    private String winnerId;
    private int maxPlayer;

    public static Game create(long id,
                              long chatId,
                              long boardGameId,
                              User host,
                              String title,
                              long userPerGameId,
                              int maxPlayer) {
        return new Game(id, chatId, boardGameId, host, title, userPerGameId, maxPlayer);
    }

    private Game(long id,
                 long chatId,
                 long boardGameId,
                 User host,
                 String title,
                 long userPerGameId,
                 int maxPlayer) {
        this.id = id;
        this.title = title;
        this.boardGameId = boardGameId;
        this.chatId = chatId;
        this.maxPlayer = maxPlayer;
        init(userPerGameId, host);
    }

    public Game() {
    }

    private void init(long userPerGameId, User host) {
        winnerId = null;
        status = Status.CREATED;
        userPerGames = new ArrayList<>();
        userPerGames.add(new UserPerGame(userPerGameId, true, host.getUsername(), 0));
    }

    public Game(long id, long chatId, String title, long boardGameId, List<UserPerGame> userPerGames, Status status, String winnerId) {
        this.id = id;
        this.chatId = chatId;
        this.title = title;
        this.boardGameId = boardGameId;
        this.userPerGames = userPerGames;
        this.status = status;
        this.winnerId = winnerId;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void end(User winner) {
        this.winnerId = winner.getUsername();
        status = Status.END;
    }

    public void newPlayerConnect(long userPerGameId, String username) {
        userPerGames.add(new UserPerGame(userPerGameId, false, username, 0));
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    public void disconnect(String username) {
        userPerGames
            .remove(
                userPerGames
                    .stream()
                    .filter(userPerGame -> java.util.Objects.equals(userPerGame.getUserId(), username))
                    .findFirst());
    }

    public boolean isOpen() {
        return userPerGames.size() <= maxPlayer && status == Status.CREATED;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getBoardGameId() {
        return boardGameId;
    }

    public List<UserPerGame> getUserPerGames() {
        return userPerGames;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBoardGameId(long boardGameId) {
        this.boardGameId = boardGameId;
    }

    public void setUserPerGames(List<UserPerGame> userPerGames) {
        this.userPerGames = userPerGames;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("id", id)
            .add("chatId", chatId)
            .add("title", title)
            .add("boardGameId", boardGameId)
            .add("userPerGames", userPerGames)
            .add("status", status)
            .add("winnerId", winnerId)
            .add("maxPlayer", maxPlayer)
            .toString();
    }
}
