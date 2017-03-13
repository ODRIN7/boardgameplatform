package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public void createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
