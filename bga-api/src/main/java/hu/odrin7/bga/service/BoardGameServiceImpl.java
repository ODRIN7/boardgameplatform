package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.domain.blog.BlogPost;
import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.domain.boardgame.BoardGameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class BoardGameServiceImpl implements BoardGameService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BoardGameRepository  boardGameRepository;

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
