package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.store.Shopping;
import hu.odrin7.bga.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/shoppings")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostConstruct
    public void fillData() {
        storeService.fillData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Shopping> getShoppingList() {
        return storeService.getAllShoppingList();
    }

    @RequestMapping(value = "/current/", method = RequestMethod.GET)
    public List<Shopping> getShoppingListByCurrentUser() {
        return storeService.getShoppingListByCurrentUser();
    }

    @RequestMapping(value = "/byUser/{userId}", method = RequestMethod.GET)
    public List<Shopping> getShoppingList(@PathVariable("userId") Long userId) {
        return storeService.getShoppingListByUser(userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Shopping addToCard(@RequestBody Shopping shopping) {
        return storeService.addToCard(shopping);
    }

    @RequestMapping(value = "/buy/{shoppingId}", method = RequestMethod.POST)
    public Shopping buy(@PathVariable("shoppingId") Long shoppingId) {
        return storeService.buy(shoppingId, shoppingId);
    }

    @RequestMapping(value = "/{shoppingId}", method = RequestMethod.DELETE)
    public Shopping deleteFromCard(@PathVariable("shoppingId") Long shoppingId) {
        return storeService.deleteShopping(shoppingId);
    }


}
