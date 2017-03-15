package hu.odrin7.bga.controller;


import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.shopping.Shopping;
import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.service.UserService;
import hu.odrin7.bga.service.exceptions.CannotFindUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostConstruct
    public void fillData() {
        userService.fillData();
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user) {
        userService.create(user);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable("username") String username) throws CannotFindUserException {
        return userService.getUserByUsername(username);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable("username") String username) {
        return userService.deleteUser(username);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public Boolean modifUser(@PathVariable("username") String username,
                             @RequestBody User user) {
        return userService.modifyByUsername(username, user);
    }

    @RequestMapping(value = "/authority/{authority}", method = RequestMethod.GET)
    public List<User> getUserByAuthority(@PathVariable("authority") Authority authority) {
        return userService.getUsersByAuthority(authority);
    }

    @RequestMapping(value = "/boardGames/{username}", method = RequestMethod.GET)
    public List<Long> getBoardGamesByUser(@PathVariable("username") String username) throws CannotFindUserException {
        return userService.getBoardGamesByUser(username);
    }

    @RequestMapping(value = "/shoppings/{username}", method = RequestMethod.GET)
    public List<Shopping> getShoppingsByUser(@PathVariable("username") String username) throws CannotFindUserException {
        return userService.getShoppingsByUser(username);
    }

    @RequestMapping(value = "/shoppings/buy/{username}", method = RequestMethod.GET)
    public boolean buyShopping(@PathVariable("username") String username,
                       @RequestBody Shopping shopping,
                       @RequestBody BoardGame boardGame) throws CannotFindUserException {
        return userService.buy(username, shopping, boardGame);
    }

    @RequestMapping(value = "/shoppings/buy/{username}", method = RequestMethod.GET)
    public boolean deleteShopping(@PathVariable("username") String username,
                       @RequestBody Shopping shopping) throws CannotFindUserException {
        return userService.deleteShopping(username, shopping);
    }

    @RequestMapping(value = "/shoppings/addToCard/{username}", method = RequestMethod.GET)
    public boolean addToCard(@PathVariable("username") String username,
                       @RequestBody Shopping shopping) throws CannotFindUserException {
        return userService.addToCard(username, shopping);
    }
}



