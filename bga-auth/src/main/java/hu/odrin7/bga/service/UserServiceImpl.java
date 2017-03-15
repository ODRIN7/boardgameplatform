package hu.odrin7.bga.service;


import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.shopping.Shopping;
import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.Role;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.repository.UserRepository;
import hu.odrin7.bga.service.exceptions.CannotFindUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void fillData() {
        List<User> users = this.getUsers();
        if (users.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                User user = new User(
                    "username" + i,
                    "password" + i,
                    Collections.singletonList(new Authority(Role.ADMIN_ROLE)),
                    "email" + i + "@email.com",
                    "http://lorempixel.com/40/40/people/" + i);
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
        return newArrayList(repository.findAll())
            .stream()
            .filter(user -> user.getAuthorities()
                .contains(authority)).collect(toList());
    }

    @Override
    public List<Long> getBoardGamesByUser(String username) throws CannotFindUserException {
        User user = repository.findOne(username);
        if (user != null) {
            return user.getBoardGamesId();
        }
        throw new CannotFindUserException("cannot Find User: " + username);
    }

    @Override
    public List<Shopping> getShoppingsByUser(String username) throws CannotFindUserException {
        User user = repository.findOne(username);
        if (user != null) {
            return user.getShoppings();
        }
        throw new CannotFindUserException("cannot Find User: " + username);
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
    public boolean buy(String username, Shopping shopping, BoardGame boardGame) throws CannotFindUserException {

        User user = getUserByUsername(username);
        if (user != null) {

            Shopping oldShopping = user.getShoppings().stream()
                .filter(shopping1 -> Objects.equals(shopping1.getId(), shopping.getId())).collect(toList()).get(0);
            user.getShoppings().remove(oldShopping);
            user.getShoppings().add(shopping);
            user.buyBoardGame(boardGame);
            repository.save(user);
            return true;
        }
        throw new CannotFindUserException("");
    }

    @Override
    public boolean deleteShopping(String username, Shopping shopping) throws CannotFindUserException {

        User user = getUserByUsername(username);
        if (user != null) {

            Shopping oldShopping = user.getShoppings().stream()
                .filter(shopping1 -> Objects.equals(shopping1.getId(), shopping.getId())).collect(toList()).get(0);
            user.getShoppings().remove(oldShopping);
            repository.save(user);
            return true;
        }
        throw new CannotFindUserException("");
    }

    @Override
    public boolean addToCard(String username, Shopping shopping) throws CannotFindUserException {
        User user = getUserByUsername(username);
        if (user != null) {
            user.addToCard(shopping);
            repository.save(user);
            return true;
        }
        throw new CannotFindUserException("");
    }

    @Override
    public boolean modifyByUsername(String username, User newUser) {
        User user = repository.findOne(username);
        if (user != null) {
            user = newUser;
            repository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User getUserByUsername(String username) throws CannotFindUserException {
        User user = repository.findOne(username);
        if (user != null) {
            return user;
        }
        throw new CannotFindUserException("cannot Find User: " + username);
    }
}
