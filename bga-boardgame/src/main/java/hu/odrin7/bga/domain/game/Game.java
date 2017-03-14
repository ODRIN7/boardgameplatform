package hu.odrin7.bga.domain.game;

import com.google.common.base.Objects;
import hu.odrin7.bga.domain.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "games")
public class Game {
    //todo id generator must have

    @Id
    private long id;
    private long chatId;
    private String title;
    private long boardGameId;
    private List<UserPerGame> userPerGame;
    private Status status;
    private String winnerId;

    public static Game create(long id, long chatId, long boardGameId, User host, String title, long userPerGameId) {
        return new Game(id, chatId, boardGameId, host, title, userPerGameId);
    }

    public Game(long id, long chatId, long boardGameId, User host, String title, long userPerGameId) {
        this.id = id;
        this.title = title;
        this.boardGameId = boardGameId;
        this.chatId = chatId;
        init(userPerGameId, host);
    }

    public Game() {
    }

    private void init(long userPerGameId, User host) {
        winnerId = null;
        status = Status.CREATED;
        userPerGame = new ArrayList<>();
        userPerGame.add(new UserPerGame(userPerGameId, true, host.getUsername(), 0));
    }

    public Game(long id, long chatId, String title, long boardGameId, List<UserPerGame> userPerGame, Status status, String winnerId) {
        this.id = id;
        this.chatId = chatId;
        this.title = title;
        this.boardGameId = boardGameId;
        this.userPerGame = userPerGame;
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

    public void newPlayerConnect(long userPerGameId, User player) {
        userPerGame.add(new UserPerGame(userPerGameId, false, player.getUsername(), 0));
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

    public List<UserPerGame> getUserPerGame() {
        return userPerGame;
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

    public void setUserPerGame(List<UserPerGame> userPerGame) {
        this.userPerGame = userPerGame;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("id", id)
            .add("chatId", chatId)
            .add("title", title)
            .add("boardGameId", boardGameId)
            .add("userPerGame", userPerGame)
            .add("status", status)
            .add("winnerId", winnerId)
            .toString();
    }
}
