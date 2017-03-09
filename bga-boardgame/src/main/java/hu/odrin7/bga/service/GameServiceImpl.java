package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.game.Game;
import hu.odrin7.bga.domain.game.GameRepository;
import hu.odrin7.bga.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class GameServiceImpl implements GameService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void fillData() {
        List<Game> games = this.getGames();
        if (games.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                Game game = Game.create(1000L,
                    new User("username1", "password1", new ArrayList<>()), "title" + i);
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
            game.newPlayerConnect(user);
            return true;
        }
        return false;
    }
}
