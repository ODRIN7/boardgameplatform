package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.user.User;

public interface UserService {

    void fillData();
    void createUser(User user);
}
