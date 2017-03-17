package hu.odrin7.bga.service;

import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.client.BoardGameServiceClient;
import hu.odrin7.bga.domain.store.Shopping;
import hu.odrin7.bga.domain.store.ShoppingRepository;
import hu.odrin7.bga.domain.store.Status;
import hu.odrin7.bga.seq.dao.SequenceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static hu.odrin7.bga.domain.store.Status.ALREADY_PAYED;
import static hu.odrin7.bga.domain.store.Status.NOT_PAYED;
import static java.util.stream.Collectors.toList;

@Service
public class StoreServiceImpl implements StoreService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String SHOPPING_SEQ_KEY = "shopping";
    private static final String CREATION_SEQ_KEY = "creationTime";
    private final ShoppingRepository shoppingRepository;
    private final AuthServiceClient authServiceClient;
    private final SequenceDao sequenceDao;
    private final BoardGameServiceClient boardGameServiceClient;

    @Autowired
    public StoreServiceImpl(ShoppingRepository shoppingRepository,
                            AuthServiceClient authServiceClient,
                            SequenceDao sequenceDao,
                            BoardGameServiceClient boardGameServiceClient) {
        this.shoppingRepository = shoppingRepository;
        this.authServiceClient = authServiceClient;
        this.sequenceDao = sequenceDao;
        this.boardGameServiceClient = boardGameServiceClient;
    }

    @Override
    public void fillData() {
        List<Shopping> shoppings = this.getAllShoppingList();
        if (shoppings.isEmpty()) {
            sequenceDao.saveNewKey(SHOPPING_SEQ_KEY, 400);
            sequenceDao.saveNewKey(CREATION_SEQ_KEY, 500);
            for (long i = 1; i <= 10; i++) {
                Shopping shopping = Shopping.create(sequenceDao.getNextSequenceId(SHOPPING_SEQ_KEY),
                    200L + i, "username" + i,
                    LocalDateTime.now(),
                    Status.ALREADY_PAYED, 100);
                shoppingRepository.save(shopping);
                log.warn(shopping.toString());
            }
        }
    }

    @Override
    public List<Shopping> getAllShoppingList() {
        return newArrayList(shoppingRepository.findAll());
    }

    @Override
    public List<Shopping> getShoppingListByUser(String username) {
        return getAllShoppingList()
            .stream()
            .filter(shopping -> authServiceClient.getShoppingsByUser(username)
                .contains(shopping.getId()))
            .collect(toList());
    }

    @Override
    public Shopping addToCard(Shopping shopping, String username) {
        setShoppingParams(shopping, username);
        authServiceClient.addToCard(username, shopping.getId());
        return shoppingRepository.save(shopping);
    }

    @Override
    public void deleteShoppings(List<Long> deletedIds, String username) {

        for (Long deletedId : deletedIds) {
            Shopping shopping = shoppingRepository.findOne(deletedId);
            if (shopping != null && isContainShopping(shopping.getId(), username)) {
                shoppingRepository.delete(shopping);
            }
            authServiceClient.deleteShoppings(username, deletedIds);
        }
    }

    @Override
    public void buy(List<Long> buyIds, String username) {

        for (Long buyId : buyIds) {
            Shopping shopping = shoppingRepository.findOne(buyId);
            if (shopping != null && isContainShopping(shopping.getId(), username)) {
                shopping.setStatus(ALREADY_PAYED);
                authServiceClient.buyShopping(username,
                    boardGameServiceClient
                        .getBoardGame(shopping.getBoardGameId()).getPrice(),
                    shopping.getId());
                shoppingRepository.save(shopping);
            }
        }
    }

    private boolean isContainShopping(long shoppingId, String username) {
        List<Long> shoppingIds = authServiceClient.getShoppingsByUser(username);
        return shoppingIds.contains(shoppingId);
    }

    private void setShoppingParams(Shopping shopping, String username) {
        shopping.setId(sequenceDao.getNextSequenceId(SHOPPING_SEQ_KEY));
        shopping.setStatus(NOT_PAYED);
        shopping.setCreationTime(
            LocalDateTime.now());
        shopping.setUserId(username);
    }

}
