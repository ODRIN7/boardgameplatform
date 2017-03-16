package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.shopping.Shopping;
import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;

import java.util.List;

public interface UserService {

    void fillData();

    List<User> getUsers();

    List<User> getUsersByAuthority(Authority authority);

    List<Long> getBoardGamesByUser(String username);

    List<Shopping> getShoppingsByUser(String username);

    void create(User user);

    User getUserByUsername(String username);

    boolean modifyByUsername(String username, User user);

    User deleteUser(String username);

    boolean buy(Shopping shopping);

    boolean deleteShopping(Shopping shopping);

    boolean addToCard(Shopping shopping);

    String getIcon(String username);

    String getEmail(String username);

    long deleteBoardGame(String username, long boardGameId);

}
