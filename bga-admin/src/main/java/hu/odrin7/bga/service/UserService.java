package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.user.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> getUsers();
}
