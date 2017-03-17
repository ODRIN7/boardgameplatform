package hu.odrin7.bga.controller;


import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.service.UserService;
import hu.odrin7.bga.service.UserServiceImpl;
import hu.odrin7.bga.service.exceptions.CannotFindUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

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
    public List<Long> getBoardGamesByUser(@PathVariable("username") String username) {
        return userService.getBoardGamesByUser(username);
    }

    @RequestMapping(value = "/boardGames/{username}/{boardGameId}", method = RequestMethod.POST)
    public long deleteBoardGame(@PathVariable("username") String username, @PathVariable("boardGameId") long boardGameId) {
        return userService.deleteBoardGame(username, boardGameId);
    }

    @RequestMapping(value = "/shoppings/{username}", method = RequestMethod.GET)
    public List<Long> getShoppingsByUser(@PathVariable("username") String username) {
        return userService.getShoppingsByUser(username);
    }

    @RequestMapping(value = "/shoppings/buy/{username}/{price}", method = RequestMethod.POST)
    public ResponseEntity buyShopping(@PathVariable("username") String username,
                                      @PathVariable("price") long price,
                                      @RequestBody Long shopping) {
        userService.buy(shopping, price, username);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/shoppings/delete/{username}", method = RequestMethod.POST)
    public ResponseEntity deleteShoppings(@PathVariable("username") String username,
                                          @RequestBody List<Long> shoppings) {
        userService.deleteShoppings(shoppings, username);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/shoppings/addToCard/{username}", method = RequestMethod.POST)
    public ResponseEntity addToCard(@PathVariable("username") String username,
                                    @RequestBody Long shopping) {
        userService.addToCard(shopping, username);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/email/{username}", method = RequestMethod.GET)
    public String getEmail(@PathVariable("username") String username) {
        return userService.getEmail(username);
    }

    @RequestMapping(value = "/icon/{username}", method = RequestMethod.GET)
    public String getIcon(@PathVariable("username") String username) {
        return userService.getIcon(username);
    }
}



