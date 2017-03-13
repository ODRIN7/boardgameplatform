package hu.odrin7.bga.controller;


import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.service.UserService;
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
    public User getUserByUsername(@PathVariable("username") String username) {
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
    public List<User> getUserByAuthority(@PathVariable("authority") Authority authority ) {
        return userService.getUsersByAuthority(authority);
    }
}



