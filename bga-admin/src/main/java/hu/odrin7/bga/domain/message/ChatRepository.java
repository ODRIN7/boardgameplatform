package hu.odrin7.bga.domain.message;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long> {
}
