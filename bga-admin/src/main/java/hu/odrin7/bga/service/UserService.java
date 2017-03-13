package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;

import java.util.List;

public interface UserService {

    void createUser(User user);
    List<User> getUsers();
    User getUserByUsername(String username);
    List<User> getUsersByAuthority(Authority authority);
    User delete(String username);
    boolean modifByUserName(String username, User user);

}
