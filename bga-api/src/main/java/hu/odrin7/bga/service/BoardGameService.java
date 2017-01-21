package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.BoardGame;

public interface BoardGameService {

    void create(BoardGame boardGame);
    String getBoardGames();
}
