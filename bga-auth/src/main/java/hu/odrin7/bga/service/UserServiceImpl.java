package hu.odrin7.bga.service;


import com.google.common.collect.Lists;
import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.Role;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.repository.UserRepository;
import hu.odrin7.bga.seq.dao.SequenceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private UserRepository repository;

    private static final String USER_SEQ_KEY = "user";
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void fillData() {
        List<User> users = this.getUsers();
        if (users.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                User user = new User(
                    "username" + i,
                    "password" + i,
                    Collections.singletonList(new Authority(Role.ADMIN_ROLE)),
                    "email" + i + "@email.com");
                create(user);
                log.warn(user.toString());
            }
        }
    }

    @Override
    public void create(User user) {
        log.info("create user ----------------------------------------------- CREATE USER ------------");
        User existing = repository.findOne(user.getUsername());
        Assert.isNull(existing, "user already exists: " + user.getUsername());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        repository.save(user);

        log.info("new user has been created: {}", user.getUsername());
    }

    @Override
    public List<User> getUsers() {
        return newArrayList(repository.findAll());
    }

    @Override
    public List<User> getUsersByAuthority(Authority authority) {
        return newArrayList(repository.findAll()).stream().filter(user -> user.getAuthorities().contains(authority)).collect(toList());
    }

    @Override
    public User deleteUser(String username) {
        User user = repository.findOne(username);
        if (user != null) {
            repository.delete(user);
        }
        return user;
    }

    @Override
    public boolean modifyByUsername(String username, User newUser) {
        User boardGame = repository.findOne(username);
        if (boardGame != null) {
            boardGame = newUser;
            repository.save(boardGame);
            return true;
        }
        return false;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = repository.findOne(username);
        if (user != null) {
            return user;
        }
        return null;
    }
}
