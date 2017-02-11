package hu.odrin7.bga.domain.game;

import hu.odrin7.bga.domain.user.User;
import org.springframework.data.annotation.Id;

public class UserPerGame {

    @Id
    private String id;

    private User user;
}
