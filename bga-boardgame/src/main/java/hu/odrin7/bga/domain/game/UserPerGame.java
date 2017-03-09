package hu.odrin7.bga.domain.game;

import hu.odrin7.bga.domain.user.User;
import org.springframework.data.annotation.Id;

public class UserPerGame {
//todo id generator must have
    private static long seq = 0L;

    private long id;
    private boolean host;
    private User user;
    private Integer score;

    public UserPerGame(User user, Integer score) {
        this.id = seq++;
        this.user = user;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public boolean isHost() {
        return host;
    }

    public void setHost(boolean host) {
        this.host = host;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
