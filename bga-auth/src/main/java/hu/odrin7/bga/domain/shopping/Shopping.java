package hu.odrin7.bga.domain.shopping;

import com.google.common.base.Objects;

import java.time.LocalDate;

public class Shopping {

    private Long id;
    private Long boardGameId;
    private String userId;
    private LocalDate creationTime;
    private Status status;
    private Integer shoppingPrice;

    public Shopping() {
    }

    public Shopping(Long id, Long boardGameId, String userId, LocalDate creationTime, Status status, Integer shoppingPrice) {
        this.id = id;
        this.boardGameId = boardGameId;
        this.userId = userId;
        this.creationTime = creationTime;
        this.status = status;
        this.shoppingPrice = shoppingPrice;
    }

    public Shopping(Long id, Long boardGameId, String userId, Status status, Integer shoppingPrice) {
        this.id = id;
        this.boardGameId = boardGameId;
        this.userId = userId;
        this.status = status;
        this.shoppingPrice = shoppingPrice;
        this.creationTime = LocalDate.now();
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

    public String getUser() {
        return userId;
    }

    public void setUser(String userId) {
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

    public Long getBoardGameId() {
        return boardGameId;
    }

    public void setBoardGameId(Long boardGameId) {
        this.boardGameId = boardGameId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getShoppingPrice() {
        return shoppingPrice;
    }

    public void setShoppingPrice(Integer shoppingPrice) {
        this.shoppingPrice = shoppingPrice;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("id", id)
            .add("boardGameId", boardGameId)
            .add("userId", userId)
            .add("creationTime", creationTime)
            .add("status", status)
            .add("shoppingPrice", shoppingPrice)
            .toString();
    }
}
