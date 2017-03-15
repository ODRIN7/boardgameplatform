package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.game.Game;

import java.security.Principal;
import java.util.List;

public interface GameService {

    void fillData();

    List<Game> getGames();

    List<Game> getOpenGames();

    List<Game> getOpenGamesByUserBoardGames(Principal principal);

    Game getGameById(long gameId);

    Game createNewGame(Game game, Principal principal);

    Game deleteGame(Long gameId, Principal principal);

    boolean connectToGame(long gameId, Principal principal);
}
