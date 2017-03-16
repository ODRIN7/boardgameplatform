package hu.odrin7.bga.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @RequestMapping(value = "/users/boardGames/{username}", method = RequestMethod.GET)
     List<Long> getBoardGamesByUser(@PathVariable("username") String username);

    @RequestMapping(value = "/users/boardGames/{boardGameId}", method = RequestMethod.POST)
    long deleteBoardGame(String username,@PathVariable("boardGameId") long boardGameId);

}
