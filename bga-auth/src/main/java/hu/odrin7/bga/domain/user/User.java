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
    private List<Authority> authority;
    private List<BoardGame> boardGames;
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
        return authority;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
