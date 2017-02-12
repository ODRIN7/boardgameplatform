package hu.odrin7.bga.service;


import com.google.common.collect.Lists;
import hu.odrin7.bga.domain.Authority;
import hu.odrin7.bga.domain.Role;
import hu.odrin7.bga.domain.User;
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
                    Collections.singletonList(new Authority(Role.ADMIN_ROLE)));
                repository.save(user);
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
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public User deleteUser(String username) {
        User user = repository.findOne(username);
        if (user != null) {
            repository.delete(user);
        }
        return user;
    }
}
