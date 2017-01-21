package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.BoardGame;
import hu.odrin7.bga.service.BoardGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/boardgame")
public class BoardGameController {

	@Autowired
	private BoardGameService boardGameService;

	@RequestMapping(method = RequestMethod.POST)
	public void createBoardGame(@Valid @RequestBody BoardGame boardGame) {
        boardGameService.create(boardGame);
	}

	@RequestMapping(method = RequestMethod.GET)
	public void getBoardGames() {
        boardGameService.getBoardGames();
	}
}
