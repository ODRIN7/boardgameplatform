package hu.odrin7.bga.domain.game;

import hu.odrin7.bga.domain.boardgame.BoardGame;
import hu.odrin7.bga.domain.user.User;
import org.springframework.data.annotation.Id;

import java.util.List;


public class Game {

    @Id
    private String id;
    private BoardGame boardGame;
    private List<UserPerGame> userPerGame;
    private Status status;
    public User getWinner(){
        return null;
    }


}
