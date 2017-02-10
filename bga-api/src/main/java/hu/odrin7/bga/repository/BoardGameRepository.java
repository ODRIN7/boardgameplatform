package hu.odrin7.bga.repository;

import hu.odrin7.bga.domain.BoardGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardGameRepository extends CrudRepository<BoardGame,Long> {
}
