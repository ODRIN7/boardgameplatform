package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.domain.store.Shopping;
import hu.odrin7.bga.domain.store.ShoppingRepository;
import hu.odrin7.bga.domain.store.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static hu.odrin7.bga.domain.store.Status.ALREADY_PAYED;

@Service
public class StoreServiceImpl implements StoreService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BoardGameStoreService boardGameStoreService;
    @Autowired
    private ShoppingRepository shoppingRepository;
    @Autowired
    private AuthServiceClient authServiceClient;

    public StoreServiceImpl() {
    }

    @Override
    public void fillData() {
        List<Shopping> shoppings = this.getAllShoppingList();
        if (shoppings.isEmpty()) {
            for (long i = 1; i <= 10; i++) {

                Shopping shopping = new Shopping(i,
                    boardGameStoreService.getShoppingBoardGames().get(0).getId(),
                    10L, LocalDate.now(), Status.NOT_PAYED);

                shoppingRepository.save(shopping);
                log.warn(shopping.toString());
            }
        }
    }

    @Override
    public List<Shopping> getAllShoppingList() {
        return Lists.newArrayList(shoppingRepository.findAll());
    }

    @Override
    public List<Shopping> getShoppingListByUser(Long userId) {
        return Lists.newArrayList(shoppingRepository.findAll());
    }

    @Override
    public Shopping addToCard(Shopping shopping) {
        return shoppingRepository.save(shopping);
    }

    @Override
    public Shopping deleteShopping(Long shoppingId) {
        Shopping shopping = shoppingRepository.findOne(shoppingId);
        if (shopping != null) {
            shoppingRepository.delete(shopping);
        }
        return shopping;
    }

    @Override
    public Shopping buy(Long shoppingId) {
        Shopping shopping = shoppingRepository.findOne(shoppingId);
        shopping.setStatus(ALREADY_PAYED);
        shoppingRepository.save(shopping);
        return shopping;
    }


}
