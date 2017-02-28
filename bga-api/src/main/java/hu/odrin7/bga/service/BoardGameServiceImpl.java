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
public class BoardGameServiceImpl implements BoardGameService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private  BoardGameRepository boardGameRepository;

    public BoardGameServiceImpl() {
    }

    @Override
    public void fillData() {
        List<BoardGame> boardGames = this.getBoardGames();
        if (boardGames.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                BoardGame boardGame = new BoardGame("Sample blog post title #" + i, "Sample blog post content #" + i, "", " ");
                boardGameRepository.save(boardGame);
                log.warn(boardGame.toString());
            }
        }
    }

    @Override
    public List<BoardGame> getBoardGames() {
        return Lists.newArrayList(boardGameRepository.findAll());
    }

    @Override
    public BoardGame saveBoardGame(BoardGame boardGame) {
        return boardGameRepository.save(boardGame);
    }

    @Override
    public BoardGame deleteBoardGame(Long postId) {
        BoardGame boardGame = boardGameRepository.findOne(postId);
        if (boardGame != null) {
            boardGameRepository.delete(boardGame);
        }
        return boardGame;
    }


}
