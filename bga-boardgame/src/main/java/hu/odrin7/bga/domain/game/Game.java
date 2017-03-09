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
    private static long seq = 100L;

    @Id
    private long id;
    private String title;
    private Long boardGameId;
    private List<UserPerGame> userPerGame;
    private Status status;
    private User winner;

    public static Game create(Long boardGameId, User host, String title) {
        return new Game(boardGameId, host, title);
    }

    private Game(Long boardGameId, User host, String title) {
        this.id = seq;
        this.title = title;
        this.boardGameId = boardGameId;
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

    public static long getSeq() {
        return seq;
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

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("id", id)
            .add("title", title)
            .add("boardGameId", boardGameId)
            .add("userPerGame", userPerGame)
            .add("status", status)
            .add("winner", winner)
            .toString();
    }
}
