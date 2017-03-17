package hu.odrin7.bga.client;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "boardgame-service")
public interface BoardGameServiceClient {
    @RequestMapping(value = "/boardgames/{boardGameId}", method = GET)
     BoardGame getBoardGame(@PathVariable("boardGameId") Long boardGameId);
}
