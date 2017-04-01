package hu.odrin7.bga.client;

import hu.odrin7.bga.domain.user.Authority;
import hu.odrin7.bga.domain.user.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @RequestMapping(method = RequestMethod.POST,
        value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createUser(User user);

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    List<User> getUsers();

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
     User getUserByUsername(@PathVariable("username") String username);

    @RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
     User deleteUser(@PathVariable("username") String username);

    @RequestMapping(value = "/users/{username}", method = RequestMethod.PUT)
     Boolean modifUser(@PathVariable("username") String username, @RequestBody User user);

    @RequestMapping(value = "/authority/{authority}", method = RequestMethod.GET)
     List<User> getUserByAuthority(@PathVariable("authority") Authority authority );
}
