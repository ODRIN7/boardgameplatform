package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.boardgame.BoardGameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardGameStoreServiceImpl implements BoardGameStoreService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BoardGameRepository boardGameRepository;

    public BoardGameStoreServiceImpl() {
    }

    @Override
    public void fillData() {
        List<BoardGame> boardGames = this.getShoppingBoardGames();
        if (boardGames.isEmpty()) {
            for (Long i = 100L; i <= 103L; i++) {
                BoardGame boardGame = new BoardGame( i, "BoardGame #" + i, "", " ");
                boardGameRepository.save(boardGame);
                log.warn(boardGame.toString());
            }
        }
    }

    @Override
    public List<BoardGame> getShoppingBoardGames() {
        return Lists.newArrayList(boardGameRepository.findAll());
    }

    @Override
    public BoardGame saveShoppingBoardGames(BoardGame boardGame) {
        return boardGameRepository.save(boardGame);
    }

    @Override
    public BoardGame deleteShoppingBoardGame(Long postId) {
        BoardGame boardGame = boardGameRepository.findOne(postId);
        if (boardGame != null) {
            boardGameRepository.delete(boardGame);
        }
        return boardGame;
    }


}
