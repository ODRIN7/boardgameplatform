package hu.odrin7.bga.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {
    @RequestMapping(value = "/users/shoppings/{username}", method = RequestMethod.GET)
    List<Long> getShoppingsByUser(@PathVariable("username") String username);

    @RequestMapping(value = "/users/shoppings/buy/{username}/{price}", method = RequestMethod.POST)
    ResponseEntity buyShopping(@PathVariable("username") String username,
                               @PathVariable("price") long price,
                               @RequestBody Long shopping);

    @RequestMapping(value = "/users/shoppings/delete/{username}", method = RequestMethod.POST)
    ResponseEntity deleteShoppings(@PathVariable("username") String username,
                                   @RequestBody List<Long> shoppings);

    @RequestMapping(value = "/users/shoppings/addToCard/{username}", method = RequestMethod.POST)
    ResponseEntity addToCard(@PathVariable("username") String username,
                             @RequestBody Long shopping);
}
