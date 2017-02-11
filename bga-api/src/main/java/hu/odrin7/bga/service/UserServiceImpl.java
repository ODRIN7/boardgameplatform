package hu.odrin7.bga.service;

import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private AuthServiceClient authServiceClient;

    @Override
    public void createUser(User user) {
        authServiceClient.createUser(user);
    }
}
