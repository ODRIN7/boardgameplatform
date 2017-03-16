package hu.odrin7.bga.client;

import hu.odrin7.bga.domain.store.Shopping;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @RequestMapping(value = "/users/shoppings/{username}", method = RequestMethod.GET)
    List<Shopping> getShoppingsByUser(@PathVariable("username") String username);

    @RequestMapping(value = "/users/shoppings/buy", method = RequestMethod.POST)
    boolean buyShopping(@RequestBody Shopping shopping);


    @RequestMapping(value = "/users/shoppings/delete", method = RequestMethod.POST)
    public boolean deleteShopping(
        @RequestBody Shopping shopping);

    @RequestMapping(value = "/users/shoppings/addToCard", method = RequestMethod.POST)
    boolean addToCard(@RequestBody Shopping shopping);
}
