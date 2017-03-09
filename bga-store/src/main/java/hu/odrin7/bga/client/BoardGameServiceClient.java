package hu.odrin7.bga.client;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "boardgame-service")
public interface BoardGameServiceClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<BoardGame> getBoardGames();

    @RequestMapping(value = "/{boardGameId}", method = RequestMethod.GET)
    BoardGame getBoardGame(@PathVariable("boardGameId") Long boardGameId);
}
