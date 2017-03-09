package hu.odrin7.bga.domain;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

public class Shopping {

    @Id
    private Long id;
    private Long boardGameId;
    private Long userId;
    private LocalDate creationTime;
    private Status status;

    public Shopping() {
    }

    public Shopping(Long id, Long boardGameId, Long userId, LocalDate creationTime, Status status) {
        this.id = id;
        this.boardGameId = boardGameId;
        this.userId = userId;
        this.creationTime = creationTime;
        this.status = status;
    }

    public Shopping(Long id, Long boardGameId, Long userId, Status status) {
        this.id = id;
        this.boardGameId = boardGameId;
        this.userId = userId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoardGame() {
        return boardGameId;
    }

    public void setBoardGame(Long boardGameId) {
        this.boardGameId = boardGameId;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public LocalDate getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDate creationTime) {
        this.creationTime = creationTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("id", id)
            .add("boardGameId", boardGameId)
            .add("userId", userId)
            .add("creationTime", creationTime)
            .add("status", status)
            .toString();
    }
}
