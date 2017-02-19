package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.boardgame.BoardGame;

import java.util.List;

public interface BoardGameStoreService {

    void fillData();

    List<BoardGame> getShoppingBoardGames();

    BoardGame saveShoppingBoardGames(BoardGame boardGame);

    BoardGame deleteShoppingBoardGame(Long postId);

}
