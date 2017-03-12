package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.service.BoardGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/boardgames")
public class BoardGameController {

    @Autowired
    private BoardGameService boardGameService;

    public BoardGameController() {
    }

    @PostConstruct
    public void fillData() {
        boardGameService.fillData();
    }


    @RequestMapping(value = "/", method = GET)
    public List<BoardGame> getBoardGames() {
        return boardGameService.getBoardGames();
    }

    @RequestMapping(value = "/{boardGameId}", method = GET)
    public BoardGame getBoardGame(@PathVariable("boardGameId") Long boardGameId) {
        return boardGameService.getBoardGameById(boardGameId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BoardGame saveBoardGame(@RequestBody BoardGame boardGame) {
        return boardGameService.saveBoardGame(boardGame);
    }

    @RequestMapping(value = "/{boardGameId}", method = RequestMethod.DELETE)
    public BoardGame deletePost(@PathVariable("boardGameId") Long boardGameId) {
        return boardGameService.deleteBoardGame(boardGameId);
    }

    @RequestMapping(value = "/{boardGameId}", method = RequestMethod.POST)
    public Boolean modifBoardGame(@PathVariable("boardGameId") long boardGameId,
                                  @RequestBody BoardGame boardGame) {
        return boardGameService.modifyById(boardGameId, boardGame);
    }
}
