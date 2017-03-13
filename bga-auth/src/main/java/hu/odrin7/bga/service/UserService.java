package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.user.User;

import java.util.List;

public interface UserService {

    void fillData();
    List<User> getUsers();
    User deleteUser(String username);
    void create(User user);

}
