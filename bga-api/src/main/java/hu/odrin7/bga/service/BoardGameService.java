package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.user.User;

import java.util.List;

public interface BoardGameService {

    List<BoardGame> getBoardGames();
    BoardGame saveBoardGame(BoardGame boardGame);
    BoardGame deleteBoardGame(Long postId);

}
