package hu.odrin7.bga.service;

import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final AuthServiceClient authServiceClient;

    @Autowired
    public UserServiceImpl(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    @Override
    public void createUser(User user) {
        authServiceClient.createUser(user);
    }

    @Override
    public List<User> getUsers() {
        return authServiceClient.getUsers();
    }

}
