package hu.odrin7.bga.domain.store;

import hu.odrin7.bga.domain.store.Shopping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends CrudRepository<Shopping,Long> {
}
