package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
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

import java.time.LocalDate;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static hu.odrin7.bga.domain.store.Status.ALREADY_PAYED;

@Service
public class StoreServiceImpl implements StoreService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String SHOPPING_SEQ_KEY = "shopping";
    private final BoardGameServiceClient boardGameServiceClient;
    private final ShoppingRepository shoppingRepository;
    private final AuthServiceClient authServiceClient;
    private final SequenceDao sequenceDao;

    @Autowired
    public StoreServiceImpl(BoardGameServiceClient boardGameServiceClient,
                            ShoppingRepository shoppingRepository,
                            AuthServiceClient authServiceClient,
                            SequenceDao sequenceDao) {
        this.boardGameServiceClient = boardGameServiceClient;
        this.shoppingRepository = shoppingRepository;
        this.authServiceClient = authServiceClient;
        this.sequenceDao = sequenceDao;
    }

    @Override
    public void fillData() {
        List<Shopping> shoppings = this.getAllShoppingList();
        if (shoppings.isEmpty()) {
            sequenceDao.saveNewKey(SHOPPING_SEQ_KEY, 300);
            for (long i = 1; i <= 10; i++) {
                Shopping shopping = new Shopping(i, 200L+i, i, LocalDate.now(), Status.ALREADY_PAYED);
                addToCard(shopping);
                log.warn(shopping.toString());
            }
        }
    }

    @Override
    public List<Shopping> getAllShoppingList() {
        return newArrayList(shoppingRepository.findAll());
    }

    @Override
    public List<Shopping> getShoppingListByCurrentUser() {
        return newArrayList(shoppingRepository.findAll());
    }

    @Override
    public List<Shopping> getShoppingListByUser(Long userId) {
        return newArrayList(shoppingRepository.findAll());
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
        Shopping shopping = shoppingRepository.findOne(shoppingId);
        shopping.setStatus(ALREADY_PAYED);
        shoppingRepository.save(shopping);
        return shopping;
    }

}
