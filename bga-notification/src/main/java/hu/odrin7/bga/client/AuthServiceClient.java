package hu.odrin7.bga.client;

import hu.odrin7.bga.domain.user.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    Principal getUser();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getUsers();
}
