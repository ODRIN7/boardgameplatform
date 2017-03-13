package hu.odrin7.bga.service;

import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.domain.user.Authority;
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

    @Override
    public User getUserByUsername(String username) {
        return authServiceClient.getUserByUsername(username);
    }

    @Override
    public List<User> getUsersByAuthority(Authority authority) {
        return authServiceClient.getUserByAuthority(authority);
    }

    @Override
    public User delete(String username) {
        return authServiceClient.deleteUser(username);
    }

    @Override
    public boolean modifByUserName(String username, User user) {
        return authServiceClient.modifUser(username, user);
    }

}
