package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.game.Game;
import hu.odrin7.bga.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostConstruct
    public void fillData() {
        gameService.fillData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @RequestMapping(value = "/opens", method = RequestMethod.GET)
    public List<Game> getOpenGames() {
        return gameService.getOpenGames();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Game> getOpenGamesByUser(Principal principal) {
        return gameService.getOpenGamesByUserBoardGames(principal);
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.GET)
    public Game getGame(@PathVariable("gameId") Long gameId) {
        return gameService.getGameById(gameId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Game createNewGame(@RequestBody Game game, Principal principal) {
        return gameService.createNewGame(game, principal);
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.DELETE)
    public Game deletePost(@PathVariable("gameId") Long gameId, Principal principal) {
        return gameService.deleteGame(gameId, principal);
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.PUT)
    public Boolean connectToGame(@PathVariable("gameId") long gameId,
                                 Principal principal) {
        return gameService.connectToGame(gameId, principal);
    }
}
