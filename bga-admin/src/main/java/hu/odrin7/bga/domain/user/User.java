package hu.odrin7.bga.domain.user;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.shopping.Shopping;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class User {

    @NotNull
    @Length(min = 3, max = 20)
    private String username;

    @NotNull
    @Length(min = 6, max = 40)
    private String password;
    private String email;
    private List<Authority> authority;
    private List<BoardGame> boardGames;
    private List<Shopping> shoppings;
    private long money;

    public User() {
    }

    public User(String username, String password, List<Authority> authority, String email) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.email = email;
        init();
    }

    public boolean addtoCard(BoardGame boardGame) {
        if (this.money <= boardGame.getPrice()) {
            boardGames.add(boardGame);
            this.money -= boardGame.getPrice();
            return true;
        }
        return false;
    }

    public boolean buyBoardGame(BoardGame boardGame) {
        if (this.money <= boardGame.getPrice()) {
            boardGames.add(boardGame);
            this.money -= boardGame.getPrice();
            return true;
        }
        return false;
    }

    public void addMoney(long money) {
        this.money = money;
    }

    public void addToCard(Shopping shopping) {
        this.shoppings.add(shopping);
    }

    private void init() {
        this.money = 0L;
        this.boardGames = new ArrayList<>();
        shoppings = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }

    public List<BoardGame> getBoardGames() {
        return boardGames;
    }

    public void setBoardGames(List<BoardGame> boardGames) {
        this.boardGames = boardGames;
    }

    public List<Shopping> getShoppings() {
        return shoppings;
    }

    public void setShoppings(List<Shopping> shoppings) {
        this.shoppings = shoppings;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
