package hu.odrin7.bga.domain.game;

import hu.odrin7.bga.domain.user.User;
import org.springframework.data.annotation.Id;

public class UserPerGame {

    private long id;
    private boolean host;
    private String userId;
    private Integer score;

    public UserPerGame(long id, boolean host, String userId, Integer score) {
        this.id = id;
        this.host = host;
        this.userId = userId;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isHost() {
        return host;
    }

    public void setHost(boolean host) {
        this.host = host;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public UserPerGame() {
    }

}
