package hu.odrin7.bga.service;

import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.domain.BOARDGAME_DUMMY_CREATOR;
import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.boardgame.BoardGameRepository;
import hu.odrin7.bga.domain.boardgame.TypeOfBoardGame;
import hu.odrin7.bga.seq.dao.SequenceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class BoardGameServiceImpl implements BoardGameService {

    private static final String BOARDGAME_SEQ_KEY = "boardgame";
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final BoardGameRepository boardGameRepository;
    private final SequenceDao sequenceDao;
    private final AuthServiceClient authServiceClient;


    @Autowired
    public BoardGameServiceImpl(BoardGameRepository boardGameRepository,
                                SequenceDao sequenceDao,
                                AuthServiceClient authServiceClient) {
        this.boardGameRepository = boardGameRepository;
        this.sequenceDao = sequenceDao;
        this.authServiceClient = authServiceClient;
    }

    @Override
    public void fillData() {
        List<BoardGame> boardGames = this.getBoardGames();
        if (boardGames.isEmpty()) {
            sequenceDao.saveNewKey(BOARDGAME_SEQ_KEY, 200);
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getMemoire(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getCattan(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getRISIKO(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getCarverna(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getCarcassone(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getChess(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getRobinsonCrouso(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getSevenWOnders(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getTERAMISTICA(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
            boardGameRepository.save(BOARDGAME_DUMMY_CREATOR.getTexasHoldem(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY)));
        }
    }

    @Override
    public List<BoardGame> getBoardGames() {
        return newArrayList(boardGameRepository.findAll());
    }

    @Override
    public List<BoardGame> getBoardGamesByType(TypeOfBoardGame typeOfBoardGame) {
        return getBoardGames().stream()
            .filter(boardGame -> boardGame.getTypeOfBoardGames()
                .contains(typeOfBoardGame)).collect(Collectors.toList());
    }

    @Override
    public List<BoardGame> getBoardGamesByIds(List<Long> boardGameIds) {
        return getBoardGames().stream()
            .filter(boardGame -> boardGameIds.contains(boardGame.getId()))
            .collect(Collectors.toList());
    }

    @Override
    public List<BoardGame> getUserBoardGames(String username) {
        return getBoardGamesByIds(authServiceClient.getBoardGamesByUser(username));
    }

    @Override
    public BoardGame getBoardGameById(long boardGameId) {

        BoardGame boardGame = boardGameRepository.findOne(boardGameId);
        if (boardGame != null) {
            return boardGame;
        }
        return null;
    }

    @Override
    public BoardGame saveBoardGame(BoardGame boardGame) {
        boardGame.setId(sequenceDao.getNextSequenceId(BOARDGAME_SEQ_KEY));
        log.info(">>>>>>>>>>>>BoardGame was created>>>:" + boardGame.getName());
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
            log.info(">>>>>>>>>>>>BoardGame was deleted>>>:" + boardGame.getName());
        }
        return boardGame;
    }

    @Override
    public long deleteBoardGameByUser(long boardGameId, String username) {
        log.info(">>>>>>>>>>>>>User: " + username + " delete>>>>>>>>>>:" + boardGameId);
        return authServiceClient.deleteBoardGame(username, boardGameId);
    }


}
