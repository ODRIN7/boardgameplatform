package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.game.Game;
import hu.odrin7.bga.domain.user.User;

import java.util.List;

public interface GameService {

    void fillData();

    List<Game> getGames();

    Game getGameById(long gameId);

    Game createNewGame(Game game);

    Game deleteGame(Long gameId);

    boolean connectToGame(User user, long gameId);
}
