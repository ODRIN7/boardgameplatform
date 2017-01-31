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
@RequestMapping("/")
public class BoardGameController {

	@Autowired
	private BoardGameService boardGameService;

	@RequestMapping(path = "/boardGame",  method = RequestMethod.POST )
	public void createBoardGame( @Valid @RequestBody BoardGame boardGame) {
        boardGameService.create(boardGame);
	}

	@RequestMapping(path = "/boardGame/all", method = RequestMethod.GET)
	public String getBoardGames() {
        return boardGameService.getBoardGames();
	}

    @RequestMapping(path = "/demo", method = RequestMethod.GET)
    public String getHello() {
         return "hello";
    }
}
