package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserForeignController {

    private final UserService userService;

    @Autowired
    public UserForeignController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user,
                           Principal principal) {
        userService.createUser(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUsers(Principal principal) {
        return userService.getUsers();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable("username") String username,
                                  Principal principal) {
        return userService.getUserByUsername(username);
    }

    @RequestMapping(value = "/authority/{authority}", method = RequestMethod.GET)
    public List<User> getUserByAuthority(@PathVariable("authority") Authority authority,
                                         Principal principal) {
        return userService.getUsersByAuthority(authority);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable("username") String username,
                           Principal principal) {
        return userService.delete(username);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public Boolean modifUser(@PathVariable("username") String username,
                             @RequestBody User user, Principal principal) {
        return userService.modifByUserName(username, user);
    }
}
