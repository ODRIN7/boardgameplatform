package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;

import java.util.List;

public interface UserService {

    void fillData();

    List<User> getUsers();

    List<User> getUsersByAuthority(Authority authority);

    void create(User user);

    User getUserByUsername(String username);

    boolean modifyByUsername(String username, User user);

    User deleteUser(String username);

}
