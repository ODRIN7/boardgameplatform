package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.store.Shopping;
import hu.odrin7.bga.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/shoppings")
public class StoreController {

    private final Logger log = LoggerFactory.getLogger(getClass());
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

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<Shopping> getShoppingList(Principal principal) {
        return storeService.getShoppingListByUser(principal.getName());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Shopping addToCard(@RequestBody Shopping shopping, Principal principal) {
        return storeService.addToCard(shopping, principal.getName());
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public ResponseEntity buy(@RequestBody List<Long> shoppings, Principal principal) {
        storeService.buy(shoppings, principal.getName());
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity deleteFromCard(@RequestBody List<Long> shoppings,
                                         Principal principal) {
        storeService.deleteShoppings(shoppings, principal.getName());
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }


}
