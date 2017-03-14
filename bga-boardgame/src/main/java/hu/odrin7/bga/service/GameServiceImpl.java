package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.game.Game;
import hu.odrin7.bga.domain.game.GameRepository;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.seq.dao.SequenceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class GameServiceImpl implements GameService {
    private static final String GAME_SEQ_KEY = "game";
    private static final String USER_PER_GAME_SEQ_KEY = "userPerGame";
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final SequenceDao sequenceDao;
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(SequenceDao sequenceDao, GameRepository gameRepository) {
        this.sequenceDao = sequenceDao;
        this.gameRepository = gameRepository;
    }

    @Override
    public void fillData() {
        List<Game> games = this.getGames();
        if (games.isEmpty()) {
            sequenceDao.saveNewKey(GAME_SEQ_KEY, 100);
            sequenceDao.saveNewKey(USER_PER_GAME_SEQ_KEY, 150);
            for (long i = 1; i <= 10; i++) {
                Game game = Game.create(sequenceDao.getNextSequenceId(GAME_SEQ_KEY), 300L, 200 + i,
                    new User("username1", "password1", new ArrayList<>()),
                    "title" + i, sequenceDao.getNextSequenceId(USER_PER_GAME_SEQ_KEY));
                gameRepository.save(game);
                log.warn(game.toString());
            }
        }
    }

    @Override
    public List<Game> getGames() {
        return newArrayList(gameRepository.findAll());
    }

    @Override
    public Game getGameById(long gameId) {
        return gameRepository.findOne(gameId);
    }

    @Override
    public Game createNewGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game deleteGame(Long gameId) {
        Game game = gameRepository.findOne(gameId);
        if (game != null) {
            gameRepository.delete(game);
        }
        return game;
    }

    @Override
    public boolean connectToGame(User user, long gameId) {
        Game game = gameRepository.findOne(gameId);
        if (game != null) {
            game.newPlayerConnect(sequenceDao.getNextSequenceId(USER_PER_GAME_SEQ_KEY),user);
            return true;
        }
        return false;
    }
}
