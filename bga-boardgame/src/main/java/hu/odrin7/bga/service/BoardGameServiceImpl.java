package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.boardgame.BoardGameRepository;
import hu.odrin7.bga.domain.boardgame.TypeOfBoardGame;
import hu.odrin7.bga.seq.dao.SequenceDao;
import hu.odrin7.bga.seq.domain.SequenceId;
import hu.odrin7.bga.seq.domain.SequenceIdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hu.odrin7.bga.domain.boardgame.TypeOfBoardGame.*;

@Service
public class BoardGameServiceImpl implements BoardGameService {

    private static final String BOARDGAME_SEQ_KEY = "boardgame";
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final BoardGameRepository boardGameRepository;
    private final SequenceDao sequenceDao;


    @Autowired
    public BoardGameServiceImpl(BoardGameRepository boardGameRepository, SequenceDao sequenceDao, SequenceIdRepository sequenceIdRepository) {
        this.boardGameRepository = boardGameRepository;
        this.sequenceDao = sequenceDao;
    }

    @Override
    public void fillData() {
        List<BoardGame> boardGames = this.getBoardGames();
        if (boardGames.isEmpty()) {
            sequenceDao.saveNewKey(BOARDGAME_SEQ_KEY, 200);
            for (int i = 1; i <= 10; i++) {
                BoardGame boardGame = BoardGame.create(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY), "Boardgame name" + i, "http://lorempixel.com/40/40/people/" + i, "description",
                    new ArrayList<>(), "", Arrays.asList(Logic, Card, Dice), 0L);
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
    public BoardGame getBoardGameById(long boardGameId) {
        return boardGameRepository.findOne(boardGameId);
    }

    @Override
    public List<BoardGame> filterBoardGame() {
        return getBoardGames();
    }

    @Override
    public BoardGame saveBoardGame(BoardGame boardGame) {
        return boardGameRepository.save(boardGame);
    }

    @Override
    public boolean modifyById(long boardGameId, BoardGame newBoardGame) {
        BoardGame boardGame = boardGameRepository.findOne(boardGameId);
        if (boardGame != null) {
            boardGame = newBoardGame;
            boardGameRepository.save(boardGame);
            return true;
        }
        return false;
    }

    @Override
    public BoardGame deleteBoardGame(Long boardGameId) {
        BoardGame boardGame = boardGameRepository.findOne(boardGameId);
        if (boardGame != null) {
            boardGameRepository.delete(boardGame);
        }
        return boardGame;
    }


}
