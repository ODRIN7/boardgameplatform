package hu.odrin7.bga.domain.store;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "shoppings")
public class Shopping {

    @Id
    private long id;
    private long boardGameId;
    private String userId;
    private LocalDateTime creationTime;
    private Status status;
    private Integer shoppingPrice;


    public Shopping() {
    }

    public Shopping(long id,
                    long boardGameId,
                    String userId,
                    LocalDateTime creationTime,
                    Status status,
                    Integer shoppingPrice) {
        this.id = id;
        this.boardGameId = boardGameId;
        this.userId = userId;
        this.creationTime = creationTime;
        this.status = status;
        this.shoppingPrice = shoppingPrice;
    }

    public static Shopping create(long id,
                                  long boardGameId,
                                  String userId,
                                  LocalDateTime creationTime,
                                  Status status,
                                  Integer shoppingPrice) {
        return new Shopping(id, boardGameId, userId, creationTime, status, shoppingPrice);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBoardGameId() {
        return boardGameId;
    }

    public void setBoardGameId(long boardGameId) {
        this.boardGameId = boardGameId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
