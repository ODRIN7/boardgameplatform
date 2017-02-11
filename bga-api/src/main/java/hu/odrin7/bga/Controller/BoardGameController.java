package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.blog.BlogPost;
import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.service.BoardGameService;
import hu.odrin7.bga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BoardGameController {

	@Autowired
	private BoardGameService boardGameService;
	@Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<BoardGame> getBoardGames() {
        return boardGameService.getBoardGames();
    }

    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public BoardGame saveBoardGame(@RequestBody BoardGame boardGame) {
        return boardGameService.saveBoardGame(boardGame);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    public BoardGame deletePost(@PathVariable("postId") Long postId) {
        return boardGameService.deleteBoardGame(postId);
    }

    @RequestMapping(path = "/",  method = RequestMethod.POST )
    public void createUser( @Valid @RequestBody User user) {
        userService.createUser(user);
    }
}
