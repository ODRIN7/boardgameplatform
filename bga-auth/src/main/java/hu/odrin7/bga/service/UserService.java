package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.shopping.Shopping;
import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.service.exceptions.CannotFindUserException;

import java.util.List;

public interface UserService {

    void fillData();

    List<User> getUsers();

    List<User> getUsersByAuthority(Authority authority);

    List<Long> getBoardGamesByUser(String username) throws CannotFindUserException;

    List<Shopping> getShoppingsByUser(String username) throws CannotFindUserException;

    void create(User user);

    User getUserByUsername(String username) throws CannotFindUserException;

    boolean modifyByUsername(String username, User user);

    User deleteUser(String username);

    boolean buy(String username, Shopping shopping, BoardGame boardGame) throws CannotFindUserException;
    boolean deleteShopping(String username, Shopping shopping) throws CannotFindUserException;
    boolean addToCard(String username, Shopping shopping) throws CannotFindUserException;

}
