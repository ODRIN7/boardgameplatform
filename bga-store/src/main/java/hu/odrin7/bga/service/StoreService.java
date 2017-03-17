package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.store.Shopping;

import java.util.List;

public interface StoreService {

    void fillData();

    List<Shopping> getAllShoppingList();

    List<Shopping> getShoppingListByUser(String username);

    Shopping addToCard(Shopping shopping, String username);

    void buy(List<Long> buyIds, String username);

    void deleteShoppings(List<Long> deletedIds, String username);

}
