package hu.odrin7.bga.domain.game;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Long> {
}
