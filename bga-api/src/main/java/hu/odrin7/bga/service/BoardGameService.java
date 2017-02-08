package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.BoardGame;
import hu.odrin7.bga.domain.User;

public interface BoardGameService {

    void create(BoardGame boardGame);
    String getBoardGames();
    void createUser(User user);
}
