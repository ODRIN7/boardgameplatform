package hu.odrin7.bga.service;

import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.domain.user.Role;
import hu.odrin7.bga.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthServiceClient authServiceClient;

    public UserServiceImpl() {
    }

    @Override
    public void createUser(User user) {
        authServiceClient.createUser(user);
    }
}
