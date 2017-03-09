package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.client.BoardGameServiceClient;
import hu.odrin7.bga.domain.store.Shopping;
import hu.odrin7.bga.domain.store.ShoppingRepository;
import hu.odrin7.bga.domain.store.Status;
import hu.odrin7.bga.domain.user.User;
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

    private final BoardGameServiceClient boardGameServiceClient;
    private final ShoppingRepository shoppingRepository;
    private final AuthServiceClient authServiceClient;

    @Autowired
    public StoreServiceImpl(BoardGameServiceClient boardGameServiceClient, ShoppingRepository shoppingRepository, AuthServiceClient authServiceClient) {
        this.boardGameServiceClient = boardGameServiceClient;
        this.shoppingRepository = shoppingRepository;
        this.authServiceClient = authServiceClient;
    }

    @Override
    public void fillData() {

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
    public Shopping buy(long userId, Long shoppingId) {
        //buy
        Shopping shopping = shoppingRepository.findOne(shoppingId);
        shopping.setStatus(ALREADY_PAYED);
        shoppingRepository.save(shopping);
        return shopping;
    }

    @Override
    public Shopping addToCard(long userId, Long shoppingId) {
        return  null;
    }

}
