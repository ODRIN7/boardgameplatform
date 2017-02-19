package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.store.Shopping;

import java.util.List;

public interface StoreService {

    void fillData();

    List<Shopping> getAllShoppingList();

    List<Shopping> getShoppingListByUser(Long userId);

    Shopping addToCard(Shopping shopping);

    Shopping buy(Long shoppingId);

    Shopping deleteShopping(Long shoppingId);

}
