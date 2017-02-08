package hu.odrin7.bga.service;

import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.domain.BoardGame;
import hu.odrin7.bga.domain.User;
import hu.odrin7.bga.repository.BoardGameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class BoardGameServiceImpl implements BoardGameService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthServiceClient authServiceClient;

    @Autowired
    private BoardGameRepository repository;

    @Override
    public void create(BoardGame boardGame) {

        BoardGame existing = repository.findOne(boardGame.getId());
        Assert.isNull(existing, "boardGame already exists: " + boardGame.getId());

        repository.save(boardGame);

        log.info("new boardGame has been created: {}", boardGame.getId());
    }

    @Override
    public String getBoardGames() {
        return "hello boardgames";
    }

    @Override
    public void createUser(User user) {
        authServiceClient.createUser(user);
    }


}
