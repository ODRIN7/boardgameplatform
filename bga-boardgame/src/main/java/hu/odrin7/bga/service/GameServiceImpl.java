package hu.odrin7.bga.service;

import hu.odrin7.bga.client.ChatServiceClient;
import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.game.Game;
import hu.odrin7.bga.domain.game.GameRepository;
import hu.odrin7.bga.domain.game.UserPerGame;
import hu.odrin7.bga.domain.message.Chat;
import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.seq.dao.SequenceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

@Service
public class GameServiceImpl implements GameService {
    private static final String GAME_SEQ_KEY = "game";
    private static final String USER_PER_GAME_SEQ_KEY = "userPerGame";
    private static final String CHAT_SEQ_KEY = "chat";
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final SequenceDao sequenceDao;
    private final GameRepository gameRepository;
    private final ChatServiceClient chatServiceClient;
    private final BoardGameService boardGameService;

    @Autowired
    public GameServiceImpl(SequenceDao sequenceDao,
                           GameRepository gameRepository,
                           ChatServiceClient chatServiceClient,
                           BoardGameService boardGameService) {
        this.sequenceDao = sequenceDao;
        this.gameRepository = gameRepository;
        this.chatServiceClient = chatServiceClient;
        this.boardGameService = boardGameService;
    }

    @Override
    public void fillData() {
        List<Game> games = this.getGames();
        if (games.isEmpty()) {
            sequenceDao.saveNewKey(GAME_SEQ_KEY, 100);
            sequenceDao.saveNewKey(USER_PER_GAME_SEQ_KEY, 150);
            sequenceDao.saveNewKey(CHAT_SEQ_KEY, 300);
            for (long i = 1; i <= 10; i++) {
                Game game = Game.create(sequenceDao.getNextSequenceId(GAME_SEQ_KEY),
                    sequenceDao.getNextSequenceId(CHAT_SEQ_KEY) + i, 200 + i,
                    new User("username1", "password1", new ArrayList<>()),
                    "title" + i, sequenceDao.getNextSequenceId(USER_PER_GAME_SEQ_KEY), 5);
                gameRepository.save(game);
                log.warn(game.toString());
            }
        }
    }

    @Override
    public List<Game> getGames() {
        return newArrayList(gameRepository.findAll());
    }

    @Override
    public List<Game> getOpenGames() {
        return newArrayList(gameRepository.findAll()).stream().filter(Game::isOpen).collect(toList());
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    @Override
    public List<Game> getOpenGamesByUserBoardGames(Principal principal) {

        List<BoardGame> usersBoardGames = boardGameService.getUserBoardGames(principal.getName());
        List<Long> boardGameIds = usersBoardGames.stream().map(BoardGame::getId).collect(toList());
        if (!usersBoardGames.isEmpty()) {
            return newArrayList(gameRepository.findAll())
                .stream()
                .filter(game -> game
                    .isOpen() &&
                    boardGameIds.contains(game.getBoardGameId()))
                .collect(toList());
        } else {
            return newArrayList();
        }
    }

    @Override
    public Game getGameById(long gameId) {
        return gameRepository.findOne(gameId);
    }

    @Override
    public Game createNewGame(Game game, String username) {
        setGameParams(game, username);

        chatServiceClient.createChatByGameCreated(
            Chat.create(game.getChatId(), game.getTitle(), game.getId(), username));
        return gameRepository.save(game);
    }

    @Override
    public Game deleteGame(Long gameId, Principal principal) {
        Game game = gameRepository.findOne(gameId);
        if (game != null && isConnectedUser(principal.getName(), game)) {
            gameRepository.delete(game);
            log.info(">>>>>>Game deleted:" + gameId + "By " + principal.getName());
        }
        return game;
    }

    @Override
    public boolean connectToGame(long gameId, String username) {
        Game game = gameRepository.findOne(gameId);
        if (game != null) {
            game.newPlayerConnect(sequenceDao.getNextSequenceId(USER_PER_GAME_SEQ_KEY), username);
            log.info(">>>>>>User connected " + username + " to " + gameId);
            chatServiceClient.connectToChat(game.getChatId(),username);
            gameRepository.save(game);
            return true;
        }
        return false;
    }

    @Override
    public boolean disconnectFromGame(long gameId, String username) {
        Game game = gameRepository.findOne(gameId);
        if (game != null) {
            game.disconnect(username);
            chatServiceClient.discconectFromChat(game.getChatId(), username);
            gameRepository.save(game);
            return true;
        }
        return false;
    }

    private void setGameParams(Game game, String  username) {
        game.setId(sequenceDao.getNextSequenceId(GAME_SEQ_KEY));
        game.setUserPerGames(new ArrayList<>());
        game.getUserPerGames().add(
            new UserPerGame(sequenceDao.getNextSequenceId(USER_PER_GAME_SEQ_KEY),
                true, username, 0));
        game.setChatId(sequenceDao.getNextSequenceId(CHAT_SEQ_KEY));
    }

    private boolean isConnectedUser(String username, Game game) {
        return game.getUserPerGames().stream().anyMatch(userPerGame -> Objects.equals(userPerGame.getUserId(), username));
    }
}
