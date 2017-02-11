package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.service.BoardGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/boardgames")
public class BoardGameController {

    @Autowired
    private  BoardGameService boardGameService;

    public BoardGameController() {
    }

    @PostConstruct
    public void fillData() {
        boardGameService.fillData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<BoardGame> getBoardGames() {
        return boardGameService.getBoardGames();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BoardGame saveBoardGame(@RequestBody BoardGame boardGame) {
        return boardGameService.saveBoardGame(boardGame);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    public BoardGame deletePost(@PathVariable("postId") Long postId) {
        return boardGameService.deleteBoardGame(postId);
    }
}
