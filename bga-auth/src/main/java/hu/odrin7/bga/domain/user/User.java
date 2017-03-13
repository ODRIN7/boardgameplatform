package hu.odrin7.bga.domain.user;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.shopping.Shopping;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private String username;
    private String password;
    private String email;
    private String icon;
    private List<Authority> authorities;
    private List<Long> boardGamesId;
    private List<Shopping> shoppings;
    private long money;

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public User() {
    }

    public User(String username, String password, List<Authority> authorities, String email, String icon) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.email = email;
        this.icon = icon;
        init();
    }

    public boolean buyBoardGame(BoardGame boardGame) {
        if (this.money <= boardGame.getPrice()) {
            boardGamesId.add(boardGame.getId());
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
        this.boardGamesId = new ArrayList<>();
        this.shoppings = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Long> getBoardGamesId() {
        return boardGamesId;
    }

    public void setBoardGamesId(List<Long> boardGamesId) {
        this.boardGamesId = boardGamesId;
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

    public User(String username, String password, String email, String icon, List<Authority> authorities, List<Long> boardGamesId, List<Shopping> shoppings, long money) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.icon = icon;
        this.authorities = authorities;
        this.boardGamesId = boardGamesId;
        this.shoppings = shoppings;
        this.money = money;
    }
}
