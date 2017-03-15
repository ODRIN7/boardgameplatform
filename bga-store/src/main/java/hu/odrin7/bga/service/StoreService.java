package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.store.Shopping;

import java.security.Principal;
import java.util.List;

public interface StoreService {

    void fillData();

    List<Shopping> getAllShoppingList();

    List<Shopping> getShoppingListByUser(Principal principal);

    Shopping addToCard(Shopping shopping,Principal principal);

    Shopping buy(long shoppingId,Principal principal);

    Shopping deleteShopping(long shoppingId,Principal principal);

}
