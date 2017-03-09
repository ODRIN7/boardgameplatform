package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UserForeignController {

    @Autowired
    private UserService userService;

    public UserForeignController() {
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user) {

    }
}
