package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;

import java.util.List;

public interface UserService {

    void fillData();

    List<User> getUsers();

    List<User> getUsersByAuthority(Authority authority);

    List<Long> getBoardGamesByUser(String username);

    List<Long> getShoppingsByUser(String username);

    void create(User user);

    User getUserByUsername(String username);

    boolean modifyByUsername(String username, User user);

    User deleteUser(String username);

    boolean buy(Long shoppingId, long price, String username);

    boolean deleteShopping(Long shopping, String username);

    boolean deleteShoppings(List<Long> shoppings, String username);

    boolean addToCard(Long shopping, String username);

    String getIcon(String username);

    String getEmail(String username);

    long deleteBoardGame(String username, long boardGameId);

}
