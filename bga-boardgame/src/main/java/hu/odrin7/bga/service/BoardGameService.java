package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.boardgame.TypeOfBoardGame;
import hu.odrin7.bga.service.exceptions.CannotFindBoardGameException;

import java.security.Principal;
import java.util.List;

public interface BoardGameService {

    void fillData();

    List<BoardGame> getBoardGames();

    List<BoardGame> getBoardGamesByType(TypeOfBoardGame typeOfBoardGame);

    List<BoardGame> getBoardGamesByIds(List<Long> boardGameIds);

    List<BoardGame> getUserBoardGames(String username);

    BoardGame getBoardGameById(long boardGameId) throws CannotFindBoardGameException;

    BoardGame saveBoardGame(BoardGame boardGame);

    boolean modifyById(long boardGameId, BoardGame newBoardGame);

    BoardGame deleteBoardGame(Long postId);
}
