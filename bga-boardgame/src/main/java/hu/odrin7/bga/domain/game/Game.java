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
    private Long boardGameId;
    private List<UserPerGame> userPerGame;
    private Status status;
    private User winner;

    public static Game create(long id, long chatId, Long boardGameId, User host, String title) {
        return new Game(id, chatId, boardGameId, host, title);
    }

    private Game(long id, long chatId, Long boardGameId, User host, String title) {
        this.id = id;
        this.title = title;
        this.boardGameId = boardGameId;
        this.chatId = chatId;
        init(host);
    }

    private Game() {
    }

    private void init(User host) {
        winner = null;
        status = Status.CREATED;
        userPerGame = new ArrayList<>();
        userPerGame.add(new UserPerGame(host, 0));
    }


    public User getWinner() {
        return winner;
    }

    public void end(User winner) {
        this.winner = winner;
        status = Status.END;
    }

    public void newPlayerConnect(User player) {
        userPerGame.add(new UserPerGame(player, 0));
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getBoardGameId() {
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

    public void setBoardGameId(Long boardGameId) {
        this.boardGameId = boardGameId;
    }

    public void setUserPerGame(List<UserPerGame> userPerGame) {
        this.userPerGame = userPerGame;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setWinner(User winner) {
        this.winner = winner;
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
            .add("winner", winner)
            .toString();
    }
}
