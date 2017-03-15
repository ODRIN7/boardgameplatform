package hu.odrin7.bga.client;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.store.Shopping;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @RequestMapping(value = "/shoppings/{username}", method = RequestMethod.GET)
    List<Shopping> getShoppingsByUser(@PathVariable("username") String username);

    @RequestMapping(value = "/shoppings/buy/{username}", method = RequestMethod.GET)
    boolean buyShopping(@PathVariable("username") String username,
                        @RequestBody Shopping shopping,
                        @RequestBody BoardGame boardGame);

    @RequestMapping(value = "/shoppings/buy/{username}", method = RequestMethod.GET)
    boolean deleteShopping(@PathVariable("username") String username,
                           @RequestBody Shopping shopping);

    @RequestMapping(value = "/shoppings/addToCard/{username}", method = RequestMethod.GET)
    public boolean addToCard(@PathVariable("username") String username,
                             @RequestBody Shopping shopping);
}
