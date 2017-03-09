package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.game.Game;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    public GameController() {
    }

    @PostConstruct
    public void fillData() {
        gameService.fillData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.GET)
    public Game getGame(@PathVariable("gameId") Long gameId) {
        return gameService.getGameById(gameId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Game createNewGame(@RequestBody Game game) {
        return gameService.createNewGame(game);
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.DELETE)
    public Game deletePost(@PathVariable("gameId") Long gameId) {
        return gameService.deleteGame(gameId);
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.POST)
    public Boolean connectToGame(@RequestBody User user,
                                 @PathVariable("gameId") long gameId) {
        return gameService.connectToGame(user, gameId);
    }
}
