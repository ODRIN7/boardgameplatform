package hu.odrin7.bga.domain.notification;

import hu.odrin7.bga.domain.game.UserPerGame;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ODRIN7_asus on 2017. 02. 11..
 */
public interface NotificationRepository extends CrudRepository<Notification,Long> {
}