package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.boardgame.BoardGame;

import java.util.List;

public interface BoardGameService {

    void fillData();

    List<BoardGame> getBoardGames();

    BoardGame getBoardGameById(long boardGameId);

    List<BoardGame> filterBoardGame();

    BoardGame saveBoardGame(BoardGame boardGame);

    boolean modifyById(long boardGameId, BoardGame newBoardGame);

    BoardGame deleteBoardGame(Long postId);
}
